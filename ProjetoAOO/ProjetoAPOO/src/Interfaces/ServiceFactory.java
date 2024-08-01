package Interfaces;

public interface ServiceFactory {
    ILivroService criarLivroService(ILivroDAO livroDAO);

}
