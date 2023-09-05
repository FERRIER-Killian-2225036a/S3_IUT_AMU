#include <arpa/inet.h>
#include <sys/socket.h>
#include <unistd.h>
#include <iostream>
#include <string.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define NUM_PORT 10013
#define BACKLOG 128
#define NB_CLIENTS 10000

using namespace std;

void exitErreur(const char * msg) {
    perror(msg);
    exit( EXIT_FAILURE);

}

int main(int argc, char * argv[]) {

    int sock_serveur = socket(AF_INET, SOCK_STREAM, 0);

    struct sockaddr_in sockaddr_serveur;
   struct sockaddr_in client;
    sockaddr_serveur.sin_family = AF_INET;
    sockaddr_serveur.sin_port = htons(NUM_PORT);
    sockaddr_serveur.sin_addr.s_addr = htonl(INADDR_ANY);
    //inet_aton("172.23.217.150",& sockaddr_serveur.sin_addr);

    int yes = 1;
    if (setsockopt(sock_serveur, SOL_SOCKET, SO_REUSEADDR, &yes, sizeof(int))
            == -1)
        exitErreur("setsockopt");

    if (bind(sock_serveur, (struct sockaddr *) &sockaddr_serveur,
            sizeof(sockaddr_in)) == -1)
        exitErreur("bind");

    if (listen(sock_serveur, BACKLOG) == -1)
        exitErreur("listen");

    char * msg;
    time_t date;

    cout << "Serveur DayTime lancé  sur le port " << NUM_PORT << endl;
    socklen_t addrlen;
    addrlen = sizeof(client);

    for (int i = 1; i <= NB_CLIENTS; i++) {
	
	;
        int sock_client = accept(sock_serveur, (struct sockaddr*) &client, &addrlen);

        if (sock_client == -1)
            exitErreur("accept");

	cout << " Le client avec l'ip " << inet_ntoa(client.sin_addr) << " s'est connecté avec le port : " << ntohs(client.sin_port)<<endl;

        date = time(NULL);
        msg = ctime(&date);

        if (write(sock_client, msg, strlen(msg)) == -1)
            exitErreur("write");

        close(sock_client);

    }
    close(sock_serveur);
    return EXIT_SUCCESS;
}

