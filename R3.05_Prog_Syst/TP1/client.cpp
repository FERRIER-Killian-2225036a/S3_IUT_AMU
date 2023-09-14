#include <arpa/inet.h> // inet_addr()
#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h> // bzero()
#include <sys/socket.h>
#include <unistd.h> // read(), write(), close()
#define MAX 80
#define PORT 10013
#define SA struct sockaddr
void func(int sockfd)
{
	char buff[MAX];
	int n;
	for (;;) {
		int temp;
		bzero(buff, sizeof(buff));
		temp = read(sockfd, buff, sizeof(buff));
		
	        if (temp == 0) {
                    printf("Server Exit...\n");
	            break; }
        	printf("From Server : %s", buff);
		
	}
}

int main()
{
	int sockfd, connfd;
	struct sockaddr_in servaddr, cli;

	// socket crée et verifié 
	sockfd = socket(AF_INET, SOCK_STREAM, 0);
	if (sockfd == -1) {
		printf("erreur création socket...\n");
		exit(0);
	}
	else
		printf("Création du socket réussi..\n");
	bzero(&servaddr, sizeof(servaddr));

	// assigner IP, PORT
	servaddr.sin_family = AF_INET;
	servaddr.sin_addr.s_addr = inet_addr("127.0.0.1");
	servaddr.sin_port = htons(PORT);

	// connecter le client socket au serveur socket
	if (connect(sockfd, (SA*)&servaddr, sizeof(servaddr))
		!= 0) {
		printf("connexion au serveur échoué...\n");
		exit(0);
	}
	else
		printf("connexiox au serveur réussi..\n");

	// function pour recupere les données
	func(sockfd);

	// fermeture du socket
	close(sockfd);
}
