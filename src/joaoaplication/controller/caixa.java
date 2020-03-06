
package joaoaplication.controller;

import java.util.ArrayList;
import java.util.Scanner;

import joaoaplication.controller.revista;
import joaoaplication.controller.colecao;

public class caixa {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerTxt = new Scanner(System.in);
    
    private int numero;
    private String identificaoEtiqueta;
    private String cor;
    
    public ArrayList<revista> listaRevista = new ArrayList<>();
    
    public void addRevista(int numeroEdicao, int ano, int caixa)
    {
        revista revistaObjeto = new revista();
        revistaObjeto.setNumeroEdicao(numeroEdicao);
        revistaObjeto.setAno(ano);
        revistaObjeto.setCaixa(ano);
        
        System.out.println("| A revista possui alguma colução? Se sim digite 1, caso contrário digite 0");
        int possuiColecao = scanner.nextInt();
        if(possuiColecao == 1)
        {
            System.out.println("| Digite o nome da coleção: ");
            String nomeColecao = scannerTxt.nextLine();
            revistaObjeto.setNome(nomeColecao);
        }
        
        listaRevista.add(revistaObjeto);
    }
    
    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    
    public int getNumero()
    {
        return this.numero;
    }
    
    public void setIdentificaoEtiqueta(String identificaoEtiqueta)
    {
        this.identificaoEtiqueta = identificaoEtiqueta;
    }
    
    public String getIdentificaoEtiqueta()
    {
        return this.identificaoEtiqueta;
    }
    
    public void setCor(String cor)
    {
        this.cor = cor;
    }
    
    public String getCor()
    {
        return this.cor;
    }
}
