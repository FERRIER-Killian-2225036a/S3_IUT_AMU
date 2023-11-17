/**
 *
 * @File : nsSysteme.cxx
 *
 *
 * @Synopsis : definition des wrappers non inline des fonctions syst
 *initialement vide
 *
**/


#include "nsSysteme.h"

#include <fcntl.h>


void nsFctShell::FileCopy(const char *dest, const char *source, const size_t NbBytes) {
	// Ouvre le fichier source en mode lecture
	int source_fd = nsSysteme::Open(source, O_RDONLY);
	if (source_fd == -1) {
	    // Gérer l'erreur d'ouverture du fichier source
	    perror("Erreur lors de l'ouverture du fichier source");
	    return;
	}

	// Ouvre le fichier destination en mode écriture, création et troncature
	int dest_fd = nsSysteme::Open(dest, O_WRONLY | O_CREAT | O_TRUNC, 0666);
	if (dest_fd == -1) {
	    // Gérer l'erreur d'ouverture du fichier destination
	    perror("Erreur lors de l'ouverture du fichier destination");
	    nsSysteme::Close(source_fd); // Ferme le fichier source
	    return;
	}

	// Réserve un tampon mémoire de NbBytes+1 octets
	char *buffer = new char[NbBytes + 1];

	// Boucle de lecture et écriture
	ssize_t bytesRead;
	while ((bytesRead = nsSysteme::Read(source_fd, buffer, NbBytes)) > 0) {
	    // Écrit le nombre d'octets lus depuis le tampon dans le fichier destination
	    nsSysteme::Write(dest_fd, buffer, bytesRead);
	}

	// Ferme les fichiers et libère la mémoire du tampon
	nsSysteme::Close(source_fd);
	nsSysteme::Close(dest_fd);
	delete[] buffer;
}

