package com.livro.decorator;

import com.livro.Livro;

public abstract class LivroDecorator {
	protected Livro livro;

	public LivroDecorator(Livro livro) {
        super(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco(), livro.getTipo(), livro.getTema());
        this.livro = livro;
    }
	@Override
    public abstract String getTipo();
}
