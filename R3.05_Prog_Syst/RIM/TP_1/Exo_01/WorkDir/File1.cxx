// debut fichier File1.cxx, a mettre dans le repertoire WorkDir
  #include <iostream>
  #include "notreEntete.h"

  int main() {
  int a,b;
  std::cin >> a >> b;
  int c (calculer(a,b));
  std::cout << "\n" << c;
  return(0);
  }
// fin fichier File1.cxx
