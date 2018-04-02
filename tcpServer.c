#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define PORT 36846

void main(){

	int sockfd;
	struct sockaddr_in serverAddr;

	int newSocket;
	struct sockaddr_in newAddr;

	socklen_t addr_size;
	char buffer[1024];

	sockfd = socket(AF_INET, SOCK_STREAM, 0);
	printf("[+]Server Socket Created Sucessfully.\n");
	memset(&serverAddr, '\0', sizeof(serverAddr));

	serverAddr.sin_family = AF_INET;
	serverAddr.sin_port = htons(PORT);
	serverAddr.sin_addr.s_addr = INADDR_ANY;

	bind(sockfd, (struct sockaddr*)&serverAddr, sizeof(serverAddr));
	printf("[+] Bind to Port number %d.\n", 36846);

	listen(sockfd, 5);
	printf("[+] Listening...\n");

	newSocket = accept(sockfd, (struct sockaddr*)&newAddr, &addr_size);

	recv(newSocket, buffer, 1024,0);
	printf("[+] Data Receive: %s\n",buffer);
	
	strcpy(buffer, "Waalaikumusalam\n");
	send(newSocket, buffer, strlen(buffer), 0);
	
	recv(newSocket, buffer, 1024,0);
	printf("[+] Data Receive: %s\n",buffer);
	
	strcpy(buffer, "Are You A Muslim?");
	send(newSocket, buffer, strlen(buffer), 0);	
	
	printf("[+] Closing the connection.\n");



}
