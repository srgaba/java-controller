
package joaoaplication;

import java.util.ArrayList;
import java.util.Scanner; 

import joaoaplication.controller.caixa;
import joaoaplication.controller.colecao;
import joaoaplication.controller.revista;
import joaoaplication.controller.emprestimo;


public class index {    
    public static void main(String[] args) {
        ArrayList<caixa> listaCaixa = new ArrayList<>();
        ArrayList<emprestimo> listaEmprestimos = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        Scanner scannerText = new Scanner(System.in);
        int respSairPrincipal = 0;
        int opcao = 0;
        
        do 
        {
            
            System.out.println("Olá João, escolha uma das opções abaixo: ");
            System.out.println("-------------------------------------------");
            System.out.println("| 1 - Registar uma nova caixa");
            System.out.println("| 2 - Registar uma nova revista");
            System.out.println("| 3 - Abrir uma caixa");
            System.out.println("| 4 - Emprestar uma revista");
            System.out.println("| 5 - Verificar empréstimos");
            System.out.println("| 0 - Sair");
            System.out.println("-------------------------------------------");
            
            opcao = scanner.nextInt();
            switch(opcao)
            {
                case 1:
                    System.out.println("| Digite a identificação da etiqueta");
                    String identificaoEtiqueta = scannerText.nextLine();
                    
                    System.out.println("| Digite a cor");
                    String cor = scannerText.nextLine();
                    
                    caixa caixaObjeto = new caixa();
                    int numero = listaCaixa.size() + 1;
                    
                    caixaObjeto.setNumero(numero);
                    caixaObjeto.setIdentificaoEtiqueta(identificaoEtiqueta);
                    caixaObjeto.setCor(cor);

                    listaCaixa.add(caixaObjeto);
                    System.out.println("| Caixa número " + numero + " registrada com sucesso!");
                break;
                
                case 2:
                    System.out.println("| Em qual caixa deseja colocar a revista? (Digite o número)");
                    int numeroCaixa = scanner.nextInt();
                    numeroCaixa--;
                    
                    int larguraCaixas = listaCaixa.size();
                    if(numeroCaixa <= larguraCaixas)
                    {
                        System.out.println("| Digite o número de edição ");
                        int numeroEdicao = scanner.nextInt();
                        
                        System.out.println("| Digite o ano");
                        int ano = scanner.nextInt();
                        
                        
                        listaCaixa.get(numeroCaixa).addRevista(numeroEdicao, ano, numeroCaixa);
                        System.out.println("| Revista cadastrada com sucesso");
                    }else{
                        System.out.println("O número da caixa é inválida!");
                    }
                break;
                
                case 3:
                       System.out.println("| Digite o número da caixa: ");
                       int caixaNumero = scanner.nextInt();
                       caixaNumero--;
                       int caixaLargura = listaCaixa.size();
                       
                       if(caixaNumero <= caixaLargura)
                       {
                           System.out.println("---------------------------------------");
                           System.out.println("Caixa número: " + listaCaixa.get(caixaNumero).getNumero());
                           System.out.println("Identificação: " + listaCaixa.get(caixaNumero).getIdentificaoEtiqueta());
                           System.out.println("Cor: " + listaCaixa.get(caixaNumero).getCor());
                           System.out.println("---------------------------------------");
                           
                           for(int i = 0; i < listaCaixa.get(caixaNumero).listaRevista.size(); i++)
                           {
                               System.out.println("Revista número: " + listaCaixa.get(caixaNumero).listaRevista.get(i).getNumeroEdicao());
                               System.out.println("Revista ano: " + listaCaixa.get(caixaNumero).listaRevista.get(i).getAno());
                               System.out.println("Revista coleção: " + listaCaixa.get(caixaNumero).listaRevista.get(i).getNome());
                               System.out.println("---------------------------------------");
                           }
                       }
                break;
                
                case 4:
                    int rspFourCase = 0;
                    do  
                    {
                       emprestimo emprestimoObjeto = new emprestimo();
                       
                       System.out.println("| Digite o nome do amigo:  ");
                       String nomeAmigo = scannerText.nextLine();
                       emprestimoObjeto.setNome(nomeAmigo);
                       
                       System.out.println("| Digite o telefone do amigo:  ");
                       String telefoneAmigo = scannerText.nextLine();
                       emprestimoObjeto.setTelefone(telefoneAmigo);
                       
                       System.out.println("| Digite o endereço do amigo:  ");
                       String endAmigo = scannerText.nextLine();
                       emprestimoObjeto.setLocalAmigo(endAmigo);
                       
                       System.out.println("| Digite a data de devolução ");
                       String dataDevo = scannerText.nextLine();
                       emprestimoObjeto.setDataDevolucao(dataDevo);
                       
                       System.out.println("| Digite a data de empréstimo ");
                       String dataEmpre = scannerText.nextLine();
                       emprestimoObjeto.setDataEmprestimo(dataEmpre);
                    
                       
                       System.out.println("| Digite o ID da revista que deseja emprestar (número edição)");
                       int idRevista = scanner.nextInt();
                       
                       boolean achouRevista = false;
                       int posicaoCaixa = 0;
                       int posicaoCaixaRevista = 0;
                        
                       for(int i = 0; i < listaCaixa.size(); i++)
                       {
                           for(int e = 0; e < listaCaixa.get(i).listaRevista.size(); e++)
                           {
                               if(idRevista == listaCaixa.get(i).listaRevista.get(e).getNumeroEdicao())
                               {
                                   achouRevista = true;
                                   posicaoCaixa = i;
                                   posicaoCaixaRevista = 0;
                                   break;
                               }
                           }
                       }
                       
                       if(achouRevista == true)
                       {
                            emprestimoObjeto.setIdRevista(idRevista);
                            listaEmprestimos.add(emprestimoObjeto);
                            listaCaixa.get(posicaoCaixa).listaRevista.remove(posicaoCaixaRevista);
                            System.out.println("| Revista emprestada com sucesso");
                       }
                       else
                       {
                           System.out.println("| Não encontramos esta revista");
                       }
                       
                       System.out.println("| Para continuar na aba de empréstimo, digite 0");
                       rspFourCase = scanner.nextInt();
                    }while(rspFourCase == 0);
                break;
                
                case 5:
                    for(int i = 0; i < listaEmprestimos.size(); i++)
                    {
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("Nome: " +listaEmprestimos.get(i).getNome());
                        System.out.println("Telefone: " +listaEmprestimos.get(i).getTelefone());
                        System.out.println("Endereço: " +listaEmprestimos.get(i).getLocalAmigo());
                        System.out.println("Data empréstimo " +listaEmprestimos.get(i).getDataEmprestimo());
                        System.out.println("Data devolução " +listaEmprestimos.get(i).getDataDevolucao());
                    }
                break;
            }
            
            System.out.println("| Para voltar ao menu principal, digite 1");
            respSairPrincipal = scanner.nextInt();
        }while(respSairPrincipal == 1);
    }
    
    //public void addCaixa(String identificaoEtiqueta, String cor)
    //{
    //    caixa caixaObjeto = new caixa();
    //    int numero = this.listaCaixa.size() + 1;
    //    
    //    caixaObjeto.setNumero(numero);
    //    caixaObjeto.setIdentificaoEtiqueta(identificaoEtiqueta);
    //    caixaObjeto.setCor(cor);
    //            
    //    this.listaCaixa.add(caixaObjeto);
    //} 

}
