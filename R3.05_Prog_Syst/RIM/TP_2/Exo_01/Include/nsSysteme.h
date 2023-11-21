/**
 *
 * @File : nsSysteme.h
 *
 * @Synopsis : espace de noms qui contient les prototypes des wrappers
 *             des fonctions systeme
 *
 *
 **/
#if !defined __NSSYSTEME_H__
#define      __NSSYSTEME_H__

#include <cstddef>        // size_t

#include <sys/types.h>    // ssize_t

#include <sys/stat.h>     // struct stat, stat(), fstat()

#include <unistd.h>       // open(), read(), write(), close()

#include "string.h"

#include "CExc.h"

#include <fcntl.h>

//  Declarations des fonctions concernant les fichiers
//  =========================================================

namespace nsSysteme
{
	void 	Stat	(const char * file_name, struct stat * buf);
                             // throw (CExc);

	void 	Close	(int fd);
                             // throw (CExc);
	int 	Open	(const char * pathname, int flags);
       	                     // throw (CExc);
	int 	Open	(const char * pathname, int flags, ::mode_t mode);
                             // throw (CExc);
	std::size_t Read (int fd, void * buf, std::size_t count);
                             // throw (CExc);
	std::size_t Write (int fd, const void * buf, std::size_t count);
                             // throw (CExc);
} // nsSysteme

namespace nsFctShell
{
	void FileCopy(const char *dest, const char *source, const size_t NbBytes);
}

//  Definitions courtes des fonctions concernant les fichiers
//  =========================================================

inline
void nsSysteme::Stat (const char * file_name, struct stat * buf) // throw (CExc)
{
	if (::stat (file_name, buf))
		throw CExc ("stat()", std::string("fichier :")+ file_name);

} // Stat()

inline
void nsSysteme::Close (int fd) // throw (CExc)
{
	if (::close (fd)) 
		throw CExc ("close()", fd);

} // Close()

inline 
std::size_t nsSysteme::Read (int fd, void * buf, std::size_t count)
    // throw (CExc)
{
	::ssize_t Res;
	if (-1 == (Res = ::read (fd, buf, count)))
		throw CExc ("read()", fd);

	return Res;

} // Read()

inline
std::size_t nsSysteme::Write (int fd, const void * buf, std::size_t count)
    // throw (CExc)
{
	::ssize_t Res;
	if (-1 == (Res = ::write (fd, buf, count)))
		throw CExc ("write()", fd);

	return Res;
} // Write()

inline
int nsSysteme::Open (const char * pathname, int flags)
    // throw (CExc)
{
	int Res;
	if (-1 == (Res = ::open (pathname, flags)))
		throw CExc ("open()", std::string("fichier :")+ pathname);

	return Res;
} // Open()

inline
int nsSysteme::Open (const char * pathname, int flags, ::mode_t mode)
    // throw (CExc)
{
	int Res;
	if (-1 == (Res = ::open (pathname, flags)))
		throw CExc ("open()", std::string("fichier :")+ pathname);

	return Res;
} // Open()

#endif    /* __NSSYSTEME_H__ */

