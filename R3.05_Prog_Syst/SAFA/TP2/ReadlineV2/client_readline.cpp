#include <arpa/inet.h>
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define TAILLE_BUFFER 5 //petite taille pour le test

using namespace std;

void exitErreur(const char * msg) {
	perror(msg);
	exit( EXIT_FAILURE);

}

int main(int argc, char * argv[]){

// argv[1] : l'adresse IP du serveur auquel on veut se connecter
// argv[2] : le port du serveur auquel on veut se connecter
	
if(argc <3){
    cout << "Usage executable adresse_serveur port_serveur";
	exit(EXIT_FAILURE);
}
		

int sock_client = socket(AF_INET, SOCK_STREAM,0);

struct sockaddr_in sockaddr_serveur;

sockaddr_serveur.sin_family = AF_INET; 

inet_aton(argv[1], &sockaddr_serveur.sin_addr);

sockaddr_serveur.sin_port = htons(atoi(argv[2])) ;


if (connect(sock_client, (struct sockaddr *)&sockaddr_serveur, sizeof (sockaddr_serveur)) == -1)  
	exitErreur("connect");  

char buff[80];
int n;
for (;;) {
    bzero(buff, sizeof(buff));
    printf("Enter the string : ");
    n = 0;
    while ((buff[n++] = getchar()) != '\n');
    write(sock_client, buff, sizeof(buff));
    bzero(buff, sizeof(buff));
    read(sock_client, buff, sizeof(buff));
    printf("From Server : %s", buff);
    if ((strncmp(buff, "Bye", 3)) == 0) {
        printf("Client Exit...\n");
        break;
    }
}

close(sock_client);

}

