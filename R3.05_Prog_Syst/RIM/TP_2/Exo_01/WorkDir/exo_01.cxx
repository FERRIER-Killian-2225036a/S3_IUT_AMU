/**
 *
 * @File : ModeleExo.cxx, Fichiers
 *
 * @Author : A. B. Dragut, V. Risch
 *
 * @Synopsis : mise en place du main()
 *             et de la bibliotheque libSys
 *             fonction Stat() 
 *
 **/

#include <string>
#include <exception>

#include <sys/stat.h> // struct stat
#include "string.h"

#include "CExc.h"

#include "nsSysteme.h"  // Stat()

#include <iostream>
#include <ctime>

using namespace nsSysteme; // Stat()
using namespace std;

int main(int argc, char *argv[]) {
    try {
        if (argc != 4) {
            cerr << "Usage: " << argv[0] << " <mode> <fichier_source> <fichier_destination>" << endl;
            return 1;
        }

        const string mode = argv[1];
        const string sourceFile = argv[2];
        const string desmaketinationFile = argv[3];

        // Appelle GetSizeInBytes() pour connaître la taille en octets du tampon
        size_t bufferSize = GetSizeInBytes(mode, sourceFile);

        // Affiche la taille du tampon obtenue
        cout << "Taille buffer: " << bufferSize << " bytes" << endl;

        // Mesure du temps d'exécution
        clock_t start, end;
        start = clock();

        // Appelle FileCopy() pour copier le fichier source sur la destination
        FileCopy(destinationFile.c_str(), sourceFile.c_str(), bufferSize);

        end = clock();
        double cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

        // Affiche le temps d'exécution
        cout << "Temps d'execution: " << cpu_time_used << " seconds" << endl;

    } catch (const CExc &Exc) {
        cerr << Exc << endl;
        return errno;
    } catch (const exception &Exc) {
        cerr << "Exception: " << Exc.what() << endl;
        return 1;
    } catch (...) {
        cerr << "Une erreur iconnu est survenue" << endl;
        return 1;
    }

    return 0;
}

namespace {
    size_t GetSizeInBytes(const std::string &How, const std::string &FileName) {
        struct stat fileStat;

        // Utilise Stat() pour obtenir les informations sur le fichier
        nsSysteme::Stat(FileName.c_str(), &fileStat);

        // Détermine la taille en fonction de la manière choisie
        if (How == "char") {
            // Caractère par caractère
            return 1;
        } else if (How == "block") {
            // Taille du bloc (st_blksize)
            return static_cast<size_t>(fileStat.st_blksize);
        } else if (How == "all") {
            // Taille totale du fichier (st_size)
            return static_cast<size_t>(fileStat.st_size);
        } else {
            // Valeur par défaut en cas de manière non reconnue
            return 0;
        }
    }
} // namespace

