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
	int temp;
	bzero(buff, sizeof(buff));
	strcpy(buff, "GET /tp1.html\r\n");
	write(sockfd, buff, sizeof(buff));

	for (;;) {
		bzero(buff, sizeof(buff));
		temp = read(sockfd, buff, sizeof(buff));
		
	        if (temp == 0) {
                    printf("Server Exit...\n");
	            break; }
        	printf("From Server : %s", buff);
		
	}
}

int main(int argc, char *argv[])
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
	char *iparg = argv[1];
	char *portarg= argv[2];
	servaddr.sin_family = AF_INET;
	servaddr.sin_addr.s_addr = inet_addr(iparg);
	unsigned short port = (unsigned short) strtoul(portarg, NULL, 0);
	servaddr.sin_port = htons(port);

	// connecter le client socket au serveur socket
	if (connect(sockfd, (SA*)&servaddr, sizeof(servaddr))
		!= 0) {
		printf("connexion au serveur échoué...\n");
		exit(0);
	}
	else
		printf("connexion au serveur réussi..\n");

	// function pour recupere les données
	func(sockfd);

	// fermeture du socket
	close(sockfd);
}
