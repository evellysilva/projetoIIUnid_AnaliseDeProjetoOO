package com.negocio;

public abstract class LivroFactory implements AbstractFactory {
	@Override
    public Livro criar(String tipo) {
        if (tipo.equalsIgnoreCase("fisico")) {
            return new LivroBuilder()
                    .id(1)
                    .titulo("Livro Físico")
                    .autor("Autor Físico")
                    .editora("Editora Físico")
                    .preco(50.0)
                    .tipo("Físico")
                    .tema("Ficção")
                    .build();
        } else if (tipo.equalsIgnoreCase("digital")) {
            return new LivroBuilder()
                    .id(2)
                    .titulo("Livro Digital")
                    .autor("Autor Digital")
                    .editora("Editora Digital")
                    .preco(30.0)
                    .tipo("Digital")
                    .tema("Tecnologia")
                    .build();
        }
        return null;
    }

}
