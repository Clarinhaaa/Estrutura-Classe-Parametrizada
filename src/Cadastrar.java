public class Cadastrar<T> {
    private Object[] array = new Object[5];
    private int totalItens = 0;

    public void adicionar(T coisa) {
        aumentarArray(array);
        array[totalItens] = coisa;
        totalItens++;
    }

    public void adicionarItemPosicao(T coisa, int posicao) {
        if (!verificarPosicaoAdicionar(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        aumentarArray(array);
        for (int i = this.totalItens; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = coisa;
        totalItens++;
    }

    private void aumentarArray(Object[] array) {
        if (this.array[array.length - 1] != null) {
            Object[] novoArray = new Object[array.length + 5];
            System.arraycopy(this.array, 0, novoArray, 0, totalItens);
            this.array = novoArray;
        }
    }

    public void excluirItemPosicao(int posicao) {
        if (!verificarPosicaoExcluir(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        for (int i = posicao; i < this.totalItens - 1; i++) {
            array[i] = array[i + 1];
        }
        totalItens--;
        array[totalItens] = null;
    }

    private boolean verificarPosicaoExcluir(int posicao) {
        if (this.totalItens == 0) {
            return false;
        }

        return posicao >= 0 && posicao <= this.totalItens - 1;
    }

    private boolean verificarPosicaoAdicionar(int posicao) {
        return posicao >= 0 && posicao <= this.totalItens;
    }

    public T[] listarItens() {
        return (T[]) this.array;
    }

    public T[] listarItensPreenchidos() {
        Object[] novoArray = new Object[this.totalItens];
        System.arraycopy(this.array, 0, novoArray, 0, totalItens);
        return (T[]) novoArray;
    }

    public T procurarItem(int posicao) {
        return (T) array[posicao];
    }

    public int size() {
        return this.totalItens;
    }
}