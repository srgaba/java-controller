
package joaoaplication.controller;

import joaoaplication.controller.colecao;

public class revista extends colecao {
    private int numeroEdicao;
    private int ano;
    private int caixa;
    
    public void setNumeroEdicao(int numeroEdicao)
    {
        this.numeroEdicao = numeroEdicao;
    }
    
    public int getNumeroEdicao()
    {
        return this.numeroEdicao;
    }
    
    public void setAno(int ano)
    {
        this.ano = ano;
    }
    
    public int getAno()
    {
        return this.ano;
    }
    
    public void setCaixa(int caixa)
    {
        this.caixa = caixa;
    }
    
    public int getCaixa()
    {
        return this.caixa;
    }
}
