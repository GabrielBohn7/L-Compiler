/*

INTEGRANTES:
586595 - Gabriel Bohn
598888 - Leandro Queiroz
591526 - Lucas Ferreira

O DOCUMENTO DA GRAMATICA CONTEM AS REGRAS DA MESMA, E PODEM SER ENCONTRADAS NO CODIGO ATRAVES DOS COMENTARIOS. 
    Ex: Para encontrar a primeira regra da gramatica em nosso codigo, basta pesquisar por: Regra 1

O DOCUMENTO DA GRAMATICA CONTEM AS REGRAS DE GERACAO DE CODIGO, E PODEM SER ENCONTRADAS NO CODIGO ATRAVES DOS COMENTARIOS
    Ex: Para encontrar a primeira regra de geracao de codigo em nosso codigo, basta pesquisar por: RegraGC 1
*/

import java.io.InputStream;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Compilador {
    public static void main(String args[]) {
        try{
          // TODO: Modelar a Utilização da tabela de símbolos
          // A cada utilização da tabela de simbolos queremos ler um token e voltar para o programa principal
          // Na próxima chamada queremos voltar ao mesmo ponto do programa principal

          AnalisadorLexico analisadorLexico = new AnalisadorLexico(System.in);
          AnalisadorSintatico analisadorSintatico = new AnalisadorSintatico(analisadorLexico);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

class Tupla<K, V>{
    private K key;
    private V value;
  
    public Tupla(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}

final class TabelaSimbolos {
    private static Map<String, HashMap<RegistroLexico, Byte>> tabela = new HashMap<String, HashMap<RegistroLexico, Byte>>();
    
    public TabelaSimbolos(){
        
        tabela.put("final", new HashMap<RegistroLexico, Byte>() {{ put(new RegistroLexico("final"), (byte)0); }});
        tabela.put("int", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("int"), (byte)0); }});
        tabela.put("char", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("char"), (byte)0); }});
        tabela.put("boolean", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("boolean"), (byte)0); }});
        tabela.put("for", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("for"), (byte)0); }});
        tabela.put("if", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("if"), (byte)0); }});
        tabela.put("TRUE", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("const", "TRUE"), (byte)0); }});
        
        tabela.put("else", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("else"), (byte)0); }});
        tabela.put("and", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("and"), (byte)0); }});
        tabela.put("or", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("or"), (byte)0); }});
        tabela.put("not", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("not"), (byte)0); }});
        tabela.put(":=", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico(":="), (byte)0); }});
        tabela.put("=", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("="), (byte)0); }});
  
        tabela.put("(", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("("), (byte)0); }});
        tabela.put(")", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico(")"), (byte)0); }});
        tabela.put("<", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("<"), (byte)0); }});
        tabela.put(">", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico(">"), (byte)0); }});
        tabela.put("<>", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("<>"), (byte)0); }});
        tabela.put(">=", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico(">="), (byte)0); }});
  
        tabela.put("<=", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("<="), (byte)0); }});
        tabela.put(",", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico(","), (byte)0); }});
        tabela.put("+", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("+"), (byte)0); }});
        tabela.put("-", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("-"), (byte)0); }});
        tabela.put("*", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("*"), (byte)0); }});
        tabela.put("/", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("/"), (byte)0); }});
  
        tabela.put(";", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico(";"), (byte)0); }});
        tabela.put("{", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("{"), (byte)0); }});
        tabela.put("}", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("}"), (byte)0); }});
        tabela.put("then", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("then"), (byte)0); }});
        tabela.put("readln", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("readln"), (byte)0); }});
        tabela.put("FALSE", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("const", "FALSE"), (byte)0); }});
  
        tabela.put("write", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("write"), (byte)0); }});
        tabela.put("writeln", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("writeln"), (byte)0); }});
        tabela.put("%", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("%"), (byte)0); }});
        tabela.put("[", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("["), (byte)0); }});
        tabela.put("]", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("]"), (byte)0); }});
        tabela.put("main", new HashMap<RegistroLexico,Byte>() {{ put(new RegistroLexico("main"), (byte)0); }});
        tabela.put("id", new HashMap<RegistroLexico,Byte>());
    }

    public RegistroLexico pesquisar(String lexema){
        for(Map.Entry<String, HashMap<RegistroLexico, Byte>> entry: tabela.entrySet()){
            HashMap<RegistroLexico, Byte> valor = entry.getValue();

            for(Map.Entry<RegistroLexico, Byte> entryLinha: valor.entrySet()){
                RegistroLexico chaveLinha = entryLinha.getKey();
                if(lexema.equals(chaveLinha.getLexema())){
                    return chaveLinha;
                }
            }
        }
        return null;
    }

    public RegistroLexico inserirToken(String token, String lexema){
        HashMap<RegistroLexico, Byte> tabelaToken = tabela.get(token);
        tabelaToken.put(new RegistroLexico(token, lexema), (byte)tabelaToken.size());
        return pesquisar(lexema);
    }
}

class RegistroLexico {
    private String token;
    private String lexema;
    private int endereco;
    private String classe;
    private String tipo;
    private int tamanho;

    public RegistroLexico(String token){
        this.token = token;
        this.lexema = token;
        this.endereco = -1;
        this.classe = "vazio";
        this.tipo = "";
        this.tamanho = 0;
    }

    public RegistroLexico(String token,  String lexema){
        this.token = token;
        this.lexema = lexema;
        this.endereco = -1;
        this.classe = "vazio";
        this.tipo = "";
        this.tamanho = 0;
    }

    public RegistroLexico(String token, String lexema, int endereco, String tipo, int tamanho){
        this.lexema = lexema;
        this.token = token;
        this.classe = "vazio";
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.endereco = endereco;
    }

    public String getToken(){
        return token;
    }

    public String getLexema(){
        return lexema;
    }

    public int getEndereco(){
        if(endereco == -1){
            System.out.println("Lexema: "+ lexema);
        }
        return endereco;
    }

    public void setEndereco(int endereco){
        this.endereco = endereco;
    }

    public String getClasse(){
        return classe;
    }

    public void setClasse(String classe){
        this.classe = classe;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getTamanho(){
        return tamanho;
    }

    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    public void show(){
        System.out.println(this.lexema);
    }
    
}

class AnalisadorLexico {
    private TabelaSimbolos tabelaSimbolos = new TabelaSimbolos();
    private int contadorLinha = 1;
    private int numEstadoInicial = 0;
    private int numEstadoFinal = 20;
    private String strEntrada = "";
    private Scanner scanner;

    char [] simbolosValidos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G','H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g','h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        ':','<','>','.',',',';','(',')','[',']','{','}','+','-','%','=','*', '/',
        '\n', '\t', '\r','_', '\'', '"',' ', '?', '$',
    };

    public AnalisadorLexico(InputStream strFonte) throws Exception{
        this.scanner = new Scanner(strFonte);
        this.scanner.useDelimiter("");
    }

    public void checarCaracterValido(char caractere, int contadorLinha) throws Exception {
        if(!(new String(simbolosValidos).contains(caractere + ""))){
            throw new Exception(contadorLinha + "\ncaractere invalido.");
        }
    }

    public RegistroLexico lerString() throws Exception {
        int numEstadoAtual = 0;
        boolean devolve = false;
        boolean descarte = false;
        boolean constante = false;
        String strResultado = "";
        RegistroLexico registro = null;
        String tipo = "";
        int tamanho = 0;
        
        while(numEstadoAtual != numEstadoFinal && (scanner.hasNext() || !strEntrada.isEmpty())){

            if(strEntrada.isEmpty())
                strEntrada = scanner.next();
            
            char caractere = strEntrada.charAt(0);


            checarCaracterValido(caractere, contadorLinha);
            
            switch(numEstadoAtual){
                case 0:
                    switch(caractere){
                        case '\n':
                            contadorLinha++;
                            numEstadoAtual = numEstadoInicial;
                            descarte = true;
                            break;
                        case '\r': /* //TODO: Windows e MAC tem '\r' no final da linha, pensando em colocar para não bugar */
                        case '\t': /* //TODO: Windows e MAC tem '\r' no final da linha, pensando em colocar para não bugar */
                            numEstadoAtual = numEstadoInicial;
                            descarte = true;
                            break;
                        case ' ':
                            numEstadoAtual = numEstadoInicial;
                            descarte = true;
                            break;
                        case ':':
                            numEstadoAtual = 21; //Fixed
                            break;
                        case '<':
                            numEstadoAtual = 16;
                            break;
                        case '>':
                            numEstadoAtual = 4;
                            break;
                        // case '.':
                        case ',':
                        case ';':
                        case '(':
                        case ')':
                        case '[':
                        case ']':
                        case '{':
                        case '}':
                        case '+':
                        case '-':
                        case '%':
                        case '=':
                        case '*':
                            numEstadoAtual = numEstadoFinal;
                            break;
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            constante = true;
                            numEstadoAtual = 15;
                            break;
                        case '0':
                            constante = true;
                            numEstadoAtual = 12;
                            break;
                        case '\'':
                            constante = true;
                            numEstadoAtual = 10;
                            break;
                        case '"':
                            constante = true;
                            numEstadoAtual = 9;
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            numEstadoAtual = 1;
                            break;
                        case '_':
                            numEstadoAtual = 3;
                            break;
                        case '/':
                            numEstadoAtual = 2;
                            break;
                        default:
                            throw new Exception(contadorLinha + "\nlexema nao identificado [" + strResultado + caractere + "].");
                    } // END switch(caractere)
                    break;
                case 1:
                    switch(caractere){
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '0':
                        case '_':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            numEstadoAtual = 1;
                            break;
                        default:
                            numEstadoAtual = numEstadoFinal; // DEVOLVE
                            devolve = true;
                            break;
                    } // END switch(caractere) 
                    break;
                case 2:
                    switch(caractere){
                        case '*':
                            numEstadoAtual = 6;
                            break;
                        default:
                            numEstadoAtual = numEstadoFinal; // DEVOLVE
                            devolve = true;
                            break;
                    } // END switch(caractere)
                    break;
                case 3:
                    switch(caractere){
                        case '_':
                            numEstadoAtual = 3;
                            break;
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '0':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            numEstadoAtual = 1;
                            break;
                        default:
                            throw new Exception(contadorLinha + "\nlexema nao identificado [" + strResultado + "].");
                    } // END switch(caractere))
                    break;
                case 4:
                    switch(caractere){
                        case '=':
                            numEstadoAtual = numEstadoFinal;
                            break;
                        default:
                            numEstadoAtual = numEstadoFinal; // DEVOLVE
                            devolve = true;
                            break;
                    } // END switch(caractere)
                    break;
                case 6:
                    switch(caractere){
                        case '*':
                            numEstadoAtual = 8;
                            break;
                        case '\n':
                            contadorLinha++;
                            numEstadoAtual = 6;
                            break;
                        default:
                            numEstadoAtual = 6;
                            break;
                    } // END switch(caractere)
                    break;
                case 7:
                    switch(caractere){
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '0':
                            numEstadoAtual = 18;
                            break;
                        //case //'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            numEstadoAtual = 14;
                            break;
                        default:
                            numEstadoAtual = numEstadoFinal; // DEVOLVE
                            devolve = true;
                            tipo = "inteiro";
                            break;
                    } // END switch(caractere)
                    break;
                case 8:
                    switch(caractere){
                        case '/':
                            numEstadoAtual = numEstadoInicial;
                            descarte = true;
                            break;
                        case '*':
                            numEstadoAtual = 8;// FIXED
                            break;
                        default:
                            numEstadoAtual = 6;
                            break;
                    } // END switch(caractere)
                    break;
                case 9:
                    switch(caractere){
                        case '"':
                            numEstadoAtual = numEstadoFinal;
                            tipo = "string";
                            break;
                        case '\n':
                            throw new Exception(contadorLinha + "\ncaractere invalido.");
                        case '$':
                            throw new Exception(contadorLinha + "\ncaractere invalido.");
                        default:
                            numEstadoAtual = 9;
                            break;
                    } // END switch(caractere)
                    break;
                case 10:
                    switch(caractere){
                        case '\'': //FIXED
                            throw new Exception(contadorLinha + "\nlexema nao identificado [" + strResultado + "].");
                        default:
                            numEstadoAtual = 11;
                            break;
                    } // END switch(caractere)
                    break;
                case 11:
                    switch(caractere){
                        case '\'':
                            numEstadoAtual = numEstadoFinal;
                            tipo = "caractere";
                            break;
                        default:
                            throw new Exception(contadorLinha + "\nlexema nao identificado [" + strResultado + "].");
                    } // END switch(caractere)
                    break;
                case 12:
                    switch(caractere){
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '0':
                            numEstadoAtual = 7;
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            numEstadoAtual = 13;
                            break;
                        default:
                            numEstadoAtual = numEstadoFinal;
                            tipo = "inteiro";
                            devolve = true;
                            break;
                    } // END switch(caractere)
                    break;
                case 13:
                    switch(caractere){
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '0':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                            numEstadoAtual = 14;
                            break;
                        default:
                            throw new Exception(contadorLinha + "\nlexema nao identificado [" + strResultado + "].");
                    } // END switch(caractere)
                    break;
                case 14:
                    switch(caractere){
                        case 'h' :
                            numEstadoAtual = numEstadoFinal;
                            tipo = "inteiro"; //hexa
                            break;
                        default:
                            throw new Exception(contadorLinha + "\nlexema nao identificado [" + strResultado + "].");
                    } // END switch(caractere)
                    break;
                case 15:
                    switch(caractere){
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '0':
                            numEstadoAtual = 15;
                            break;
                        default:
                            numEstadoAtual = numEstadoFinal; // DEVOLVE
                            devolve = true;
                            tipo = "inteiro";
                            break;
                    } // END switch(caractere)
                    break;
                case 16:
                    switch(caractere){
                        case '>':
                        case '=':
                            numEstadoAtual = numEstadoFinal;
                            break;
                        default:
                            numEstadoAtual = numEstadoFinal; // DEVOLVE
                            devolve = true;
                            break;
                    } // END switch(caractere)
                    break;
                case 18:
                    switch(caractere){
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '0':
                            numEstadoAtual = 15;
                            break;
                        case 'h' :
                            numEstadoAtual = numEstadoFinal;
                            tipo = "inteiro"; //hexa
                            break;
                        default:
                            numEstadoAtual = numEstadoFinal; // DEVOLVE
                            devolve = true;
                            tipo = "inteiro";
                            break;
                    } // END switch(caractere)
                    break;
                case 21:
                    switch(caractere){
                        case '=':
                            numEstadoAtual = numEstadoFinal;
                            break;
                        default:
                            throw new Exception(contadorLinha + "\nlexema nao identificado [" + strResultado + "].");
                    } // END switch(caractere)
                    break;
            }  // END switch(numEstadoAtual)

            if(!devolve){
                strEntrada = "";
                strResultado += caractere;
            }

            if(descarte){
                strResultado = "";
                descarte = false;
            }
        }

        if(numEstadoAtual != numEstadoInicial){
            if(numEstadoAtual != numEstadoFinal)
                throw new Exception(contadorLinha + "\nfim de arquivo nao esperado.");


            if(tipo.equals("string")){
                strResultado = strResultado.replace("\"", "");
                tamanho = strResultado.length()+1;
            }
            
            if(!constante){

                registro = tabelaSimbolos.pesquisar(strResultado);

                if(registro == null){
                    registro = tabelaSimbolos.inserirToken("id", strResultado);
                }
                    
                if(registro.getLexema().equals("TRUE") || registro.getLexema().equals("FALSE")){
                    registro.setTipo("logico");
                }
            } 
            else {
                registro = new RegistroLexico("const", strResultado, -1, tipo, tamanho);
            }            
        }

        if(registro == null){
            registro = new RegistroLexico("", "", -1, "", 0);
        }

        return registro;
    }

    public int getContadorLinha(){
        return this.contadorLinha;
    }
}

class AnalisadorSintatico {
    private AnalisadorLexico analisadorLexico;
    private RegistroLexico registroLido;
    private int endereco = 4000;
    private int enderecoTemporario = 0;
    private int novoRot = 0;

    public AnalisadorSintatico(AnalisadorLexico analisadorLexico) throws Exception {
        File.open();
        this.analisadorLexico = analisadorLexico;
        this.registroLido = this.analisadorLexico.lerString();
        S();
        File.close();
        System.out.println(this.analisadorLexico.getContadorLinha() + " linhas compiladas.");
    }

    public void casaToken(String tokenEsperado) throws Exception {
        if(tokenEsperado.equals(this.registroLido.getToken())){
            this.registroLido = this.analisadorLexico.lerString();
        }
        else if(this.registroLido.getToken().equals("")){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\nfim de arquivo nao esperado");
        }
        else{
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntoken nao esperado [" + this.registroLido.getLexema() + "].");
        }
    }

    public int verificarTamanhoVetor(RegistroLexico regConst, String flagTipo) throws Exception {
        int tamanhoValido = 0;
        int tipoTamanho = 0;
        if(flagTipo.equals("inteiro")){
            tipoTamanho = 2;
        } else {
            tipoTamanho = 1;
        }
        if(regConst.getTipo().equals("inteiro")){
            
            int valorConst = 0;
            if(regConst.getLexema().indexOf("h") >= 0){
                String hex = regConst.getLexema().substring(0, regConst.getLexema().length() - 1);// Retirar o h
                valorConst = Integer.parseInt(hex,16);

            } else {
                valorConst = Integer.parseInt(regConst.getLexema());
            }
            if( valorConst > 0 && valorConst * tipoTamanho <= 8192 ){
                tamanhoValido = valorConst;
            }    
            
        } else {
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
        }

        return(tamanhoValido);
    }

    public void S() throws Exception {
        while(  this.registroLido.getToken().equals("final")   || this.registroLido.getToken().equals("int") || 
                this.registroLido.getToken().equals("boolean") || this.registroLido.getToken().equals("char")){
            Declaracao();
            casaToken(";");
        }
        casaToken("main");

        /* RegraGC 2
            dseg ENDS ; fim seg. dados
            cseg SEGMENT PUBLIC ; inicio seg. de codigo
            ASSUME CS:cseg, DS:dseg
            strt:
        */
        File.write("\ndseg ENDS ; fim seg. dados\n");
        File.write("\ncseg SEGMENT PUBLIC ; inicio seg. de codigo");
        File.write("\n\tASSUME CS:cseg, DS:dseg\n");
        File.write("\nstrt:");

        BlocoComando();
        /* RegraGC 3
            mov ah, 4Ch
            int 21h ; parar execucao do programa
            cseg ENDS ; fim seg. de codigo
            END strt ; fim do programa
        */
        mov("ah", "4Ch");
        File.write("\n\tint 21h ; parar execucao do programa");
        File.write("\ncseg ENDS ; fim seg. de codigo");
        File.write("\nEND strt ; fim do programa");
    }

    public void Declaracao() throws Exception{

        String flagSinal = "";
        
        if(this.registroLido.getToken().equals("final")){
            casaToken("final");

            /* Regra 1
                Se id.classe != vazio 
                    ERRO: identificador ja declarado [lex].
                Se não 
                    Id.classe = "constante"
                    Se não Id.classe = "constante"
            */
            RegistroLexico regId = this.registroLido;
            casaToken("id");
            if(!regId.getClasse().equals("vazio")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nidentificador ja declarado [" + regId.getLexema() + "].");
            } else {
                regId.setClasse("constante");
            }

            if(this.registroLido.getToken().equals(":=")){
                casaToken(":=");
            } else {
                casaToken("=");
            }

            if(this.registroLido.getToken().equals("-")){
                //Regra 36 sinal = reglex.lexema
                flagSinal = this.registroLido.getLexema();
                casaToken("-");
            } else if(this.registroLido.getToken().equals("+")){
                //Regra 36 sinal = reglex.lexema            
                flagSinal = this.registroLido.getLexema();
                casaToken("+");
            }

            /* Regra 15 
                Se const.Tamanho() > 0
                    ERRO tipos incompativeis
                Se sinal != "" && const.tipo != inteiro
                    ERRO identificador ja declarado
                Se não
                    Id.tipo = const.tipo;
            */
            RegistroLexico regConst = this.registroLido;
            casaToken("const");

            if(regConst.getTamanho() > 0){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }
            else if(!flagSinal.isEmpty() && !regConst.getTipo().equals("inteiro")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            } else {
                regId.setTipo(regConst.getTipo());
            }
            /* RegraGC 1
                Se idTipo == inteiro
                    Se idTamanho > 0
                        sword idTamanho DUP (?)
                    Se não 
                        Se exp
                            sword exp.lexema
                        Se nao
                            sword ?

                Se não Se idTipo == caractere
                    Se idTamanho > 0
                        Se exp
                            dseg SEGMENT PUBLIC
                            byte exp.lexema$ 
                            dseg ENDS
                        Se nao
                    Se não 
                        Se exp
                            byte exp.lexema
                        Se nao
                            byte ?

                Se não Se idTipo == logico
                    Se idTamanho > 0
                        byte idTamanho DUP (?)
                    Se não 
                        Se exp
                            byte exp.lexema
                        Se nao
                            byte ?
            */
            geraVariavel(regId, regConst);
        } 
        else {
            DeclaracaoVar();
        }
    }

    public void DeclaracaoVar() throws Exception{
        String flagTipo = "";

        if(this.registroLido.getToken().equals("int")){
            //Regra 12 idTipo =  reglex.tipo
            casaToken("int");
            flagTipo = "inteiro";
        } 
        else if(this.registroLido.getToken().equals("boolean")) {
            //Regra 12 idTipo =  reglex.tipo
            casaToken("boolean");
            flagTipo = "logico";
        } 
        else {                
            //Regra 12 idTipo =  reglex.tipo
            casaToken("char");
            flagTipo = "caractere";
        }

        Indentificador(flagTipo);

        while(this.registroLido.getToken().equals(",")){
            casaToken(",");
            Indentificador(flagTipo);
        }
    }

    public void Indentificador(String flagTipo) throws Exception {
        RegistroLexico regConst = null;
        /* Regra 2 
            Se id.classe != vazio 
                ERRO:identificador ja declarado [lex]. 
            Se não 
                Id.classe = var
        */
        RegistroLexico regId = this.registroLido;
        casaToken("id");
        if(!regId.getClasse().equals("vazio")){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\nidentificador ja declarado [" + regId.getLexema() + "].");
        } else {
            regId.setClasse("var");
        }

        //Regra 12 idTipo =  reglex.tipo
        regId.setTipo(flagTipo);

        if(this.registroLido.getToken().equals("=") || this.registroLido.getToken().equals(":=")){
            if(this.registroLido.getToken().equals(":=")){
                casaToken(":=");
            } else {
                casaToken("=");
            }
            
            String flagSinal = "";

            if(this.registroLido.getToken().equals("-")){
                //Regra 36 sinal = reglex.lexema            
                flagSinal = this.registroLido.getLexema();
                casaToken("-");
            } else if(this.registroLido.getToken().equals("+")){
                //Regra 36 sinal = reglex.lexema            
                flagSinal = this.registroLido.getLexema();
                casaToken("+");
            }
            regConst = this.registroLido;
            casaToken("const");
            
            /*Regra 5 
                Se sinal != "" && const.tipo != inteiro
                || id.tipo = inteiro && (const.tipo != inteiro && const.tipo != logico) 
                || id.tipo != inteiro && id.tipo != const.tipo 
                    ERRO: tipos incompativeis.
            */
            if((!flagSinal.isEmpty() && !regConst.getTipo().equals("inteiro")) 
                || regId.getTipo().equals("inteiro") && (!regConst.getTipo().equals("inteiro") )
                || (!regId.getTipo().equals("inteiro") && (!regId.getTipo().equals(regConst.getTipo()))))
            {
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }
            
        } else if(this.registroLido.getToken().equals("[")){
            casaToken("[");
            regConst = this.registroLido;
            casaToken("const");

            /*Regra 4
                Se const.tipo = inteiro && 0 < const.lex
                && tamanho(idTipo) * const.lex <= 8kb 
                    IdTam = const.lex
                Se não: 
                    ERRO: tamanho do vetor excede o maximo permitido.
            */
            int tamanho = verificarTamanhoVetor(regConst, flagTipo);
            if(tamanho > 0){
                regId.setTamanho(tamanho);
            } else {
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntamanho do vetor excede o maximo permitido.");
            }
            casaToken("]");

            // RegraGC auxiliar
            regConst = null;
        }
        
        /* RegraGC 1
            Se idTipo == inteiro
                Se idTamanho > 0
                    sword idTamanho DUP (?)
                Se não 
                    Se exp
                        sword exp.lexema
                    Se nao
                        sword ?

            Se não Se idTipo == caractere
                Se idTamanho > 0
                    Se exp
                        dseg SEGMENT PUBLIC
                        byte exp.lexema$ 
                        dseg ENDS
                    Se nao
                Se não 
                    Se exp
                        byte exp.lexema
                    Se nao
                        byte ?

            Se não Se idTipo == logico
                Se idTamanho > 0
                    byte idTamanho DUP (?)
                Se não 
                    Se exp
                        byte exp.lexema
                    Se nao
                        byte ?
        */
        geraVariavel(regId, regConst);
    }
    
    public void BlocoComando() throws Exception{
        casaToken("{");

        while(!this.registroLido.getToken().equals("}")){
            Comando();
        }

        casaToken("}");
    }

    public void Comando() throws Exception{
        int idTamanho = 0;

        if(this.registroLido.getToken().equals("id")){
            ComandoAtribuicao();
            casaToken(";");
        } else if(this.registroLido.getToken().equals("for")){
            ComandoRepeticao();
        }  else if(this.registroLido.getToken().equals("if")){
            ComandoTeste();
        }  else if(this.registroLido.getToken().equals("readln")){
            casaToken("readln");
            casaToken("(");

            RegistroLexico regId = this.registroLido;
            casaToken("id");

            //Regra 3 Se id.classe == vazio ERRO: identificador nao declarado [lex].
            if(regId.getClasse().equals("vazio")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nidentificador nao declarado ["+regId.getLexema()+"].");
            }

            //Regra 9  Se Id.classe  == constante- ERRO ? (classe de identificador incompativel)
            if(regId.getClasse().equals("constante")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regId.getLexema()+"].");
            }

            idTamanho = regId.getTamanho();

            if(this.registroLido.getToken().equals("[")){
                casaToken("[");
                
                RegistroLexico regExp = new RegistroLexico("expressao");
                Exp(regExp);

                //Regra 7 Se idTam = 0 ERRO classe de identificador incompatível [lex].
                if(regId.getTamanho() == 0) {
                    throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regId.getLexema()+"].");
                }
                
                casaToken("]");

                idTamanho = 0;
            }

            //Regra 11  Se id.tamanho > 0 e id.tipo != caractere ERRO: tipos incompativeis
            if(idTamanho > 0 && !regId.getTipo().equals("caractere")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }

            casaToken(")");
            casaToken(";");
        }  else if(this.registroLido.getToken().equals("write")){
            casaToken("write");
            ExpEscrita();
            casaToken(";");
        }  else if(this.registroLido.getToken().equals("writeln")){
            casaToken("writeln");
            ExpEscrita();
            casaToken(";");
        }  else { // ;
            casaToken(";");
        }
    }

    public void ExpEscrita () throws Exception {
        casaToken("(");
        RegistroLexico regExp1 = new RegistroLexico("expressao");
        Exp(regExp1);

        //Regra 10  Se Exp.tamanho > 0 (tipos incompativeis) ERRO: tipos incompativeis.
        if(regExp1.getTamanho() > 0 && !regExp1.getTipo().equals("string") && !regExp1.getTipo().equals("caractere")){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
        }
        while(this.registroLido.getToken().equals(",")){
            casaToken(",");
            RegistroLexico regExp2 = new RegistroLexico("expressao");
            Exp(regExp2);

            //Regra 10 Se Exp.tamanho > 0 (tipos incompativeis) ERRO: tipos incompativeis.
            if(regExp2.getTamanho() > 0 && !regExp2.getTipo().equals("string") && !regExp2.getTipo().equals("caractere")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }
        }
        casaToken(")");
    }

    public void ComandoAtribuicao() throws Exception{
        int idTamanho = 0;

        RegistroLexico regId = this.registroLido;
        casaToken("id");

        //Regra 3 Se id.classe == vazio ERRO: identificador nao declarado [lex].
        if(regId.getClasse().equals("vazio")){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\nidentificador nao declarado ["+regId.getLexema()+"].");
        }

        //Regra 9 Se Id.classe  == constante ERRO: classe de identificador incompativel
        if(regId.getClasse().equals("constante")){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regId.getLexema()+"].");
        }

        idTamanho = regId.getTamanho();

        if(this.registroLido.getToken().equals("[")){
            casaToken("[");
            RegistroLexico regExp1 = new RegistroLexico("expressao");
            Exp(regExp1);
            //Regra 7 Se idTam = 0 ERRO: classe de identificador incompatível [lex].
            if(regId.getTamanho() == 0) {
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regId.getLexema()+"].");
            }
            //Regra 7.1 Se Exp.tipo != inteiro ERRO:expressão inválida - tipo incompatível
            if(!regExp1.getTipo().equals("inteiro")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }

            casaToken("]");

            idTamanho = 0;
        }
        casaToken(":=");
        
        RegistroLexico regExp2 = new RegistroLexico("expressao");
        Exp(regExp2);

        //Regra 6
        if(idTamanho > 0){
            if(regExp2.getTamanho() > 0 ){
                if(regId.getTipo().equals("caractere")){
                    if( regExp2.getTipo().equals("string") || regExp2.getTipo().equals("caractere")){
                        if(regExp2.getTamanho() > idTamanho){
                            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntamanho do vetor excede o maximo permitido.");
                        }
                    } else {
                        throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
                    }
                } else {
                    throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
                }
            } else {
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }
        }
        else if (regExp2.getTamanho() == 0 ){
            if((regId.getTipo().equals("inteiro") && !(regExp2.getTipo().equals("inteiro")))
            || (regId.getTipo().equals("logico") && !regExp2.getTipo().equals("logico"))
            || (regId.getTipo().equals("caractere") && !regExp2.getTipo().equals("caractere")))
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
        } else {
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
        }

        /* RegraGC 4
            Se Exp2.tamanho > 0
                Para i no tamanho de Exp2
                    mov ax,DS:[Exp2.endereco+i]
                    mov DS:[id.endereco], ax
            Se nao
                mov ax,DS:[Exp2.endereco]
                mov DS:[id.endereco], ax
        */
        if(regExp2.getTamanho() > 0){
            for(int i = 0; i < regExp2.getTamanho(); i++){
                mov("ax", String.format("DS:[0%dh]", regExp2.getEndereco()+i));
                mov(String.format("DS:[0%dh]", regId.getEndereco()), "ax");    
            }
        } else {
            mov("ax", String.format("DS:[0%dh]", regExp2.getEndereco()));
            mov(String.format("DS:[0%dh]", regId.getEndereco()), "ax");    
        }
    }

    public void ComandoRepeticao() throws Exception{
        File.write("\n\t\t; comando repeticao");

        casaToken("for");
        casaToken("(");
        if(!this.registroLido.getToken().equals(";")){
            ComandosInternosRep();
            while(this.registroLido.getToken().equals(",")){
                casaToken(",");
                ComandosInternosRep();
            }
        }

        casaToken(";");

        /* RegraGC 5.1
            rotInicio = novoRot();
            rotFim = novoRot();
            rotInicio:
        */
        String rotInicio = novoRot();
        String rotFim = novoRot();
        File.write("\n\t"+rotInicio+":");
        File.write("\t; segundo termo repeticao");
        RegistroLexico regExp = new RegistroLexico("expressao");
        Exp(regExp);

        //Regra 8  Se Exp.tipo != logico || Exp.tamanho != 0, ERRO
        if(!regExp.getTipo().equals("logico") || regExp.getTamanho() != 0){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
        }

        /* RegraGC 5.2
            mov ax, DS:[Exp.endereco]
            cmp ax,0
            je rotFim
        */
        mov("ax", String.format("DS:[0%dh]", regExp.getEndereco()));
        cmp("ax", "0");
        je(rotFim);
        File.write("\t; sai da repeticao");

        casaToken(";");
        if(!this.registroLido.getToken().equals(")")){
            ComandosInternosRep();
            while(this.registroLido.getToken().equals(",")){
                casaToken(",");
                ComandosInternosRep();
            }
        }
        casaToken(")");
        if(!this.registroLido.getToken().equals("{")){
            Comando();
        }
        else{
            BlocoComando();
        }

        /* RegraGC 5.3
            jmp rotInicio
            rotFim:
        */
        jmp(rotInicio);
        File.write("\t; retorna ao inicio da repeticao");
        File.write("\n\t"+rotFim+":");
        File.write("\t; fim da repeticao");
    }

    public void ComandosInternosRep() throws Exception{
        int idTamanho = 0;

        if(this.registroLido.getToken().equals("id")){
            ComandoAtribuicao();
        }  else if(this.registroLido.getToken().equals("readln")){
            casaToken("readln");
            casaToken("(");

            RegistroLexico regId = this.registroLido;
            casaToken("id");
            
            //Regra 3  Se id.classe == vazio ERRO: identificador nao declarado [lex].
            if(regId.getClasse().equals("vazio")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nidentificador nao declarado ["+regId.getLexema()+"].");
            }
            
            //Regra 9  Se Id.classe  == constante ERRO: classe de identificador incompatível
            if(regId.getClasse().equals("constante")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regId.getLexema()+"].");
            }

            idTamanho = regId.getTamanho();

            if(this.registroLido.getToken().equals("[")){
                casaToken("[");
                RegistroLexico regExp = new RegistroLexico("expressao");
                Exp(regExp);

                //Regra 7 Se idTam = 0 ERRO: classe de identificador incompatível [lex].
                if(regId.getTamanho() == 0) {
                    throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regId.getLexema()+"].");
                }
                casaToken("]");
                idTamanho = 0;
            }

            //Regra 11 Se id.tamanho > 0 && id.tipo != caractere ERRO: classe de identificador incompatível [lex].

            if(idTamanho > 0 && !regId.getTipo().equals("caractere")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regId.getLexema()+"].");
            }

            casaToken(")");
        }  else if(this.registroLido.getToken().equals("write")){
            casaToken("write");
            ExpEscrita();
        }  else {
            casaToken("writeln");
            ExpEscrita();
        }
    }
    
    public void ComandoTeste() throws Exception{
        casaToken("if");

        /* RegraGC 6.1
            rotFalso = novoRot();
            rotFim = novoRot();
        */
        String rotFalso = novoRot();
        String RotFim = novoRot();

        casaToken("(");
        RegistroLexico regExp = new RegistroLexico("expressao");
        Exp(regExp);

        //Regra 8  Se Exp.tipo != logico, ERRO: tipos incompativeis.
        if(!regExp.getTipo().equals("logico")){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
        }

        /* RegraGC 6.2
            mov ax, DS:[Exp.endereco]
            cmp ax, 0
            je rotFalso 
        */
        mov("ax", String.format("DS:[0%dh]", regExp.getEndereco()));
        File.write(";\t comando teste");
        cmp("ax", "0");
        je(rotFalso);

        casaToken(")");
        casaToken("then");

        if(this.registroLido.getToken().equals("{")){
            BlocoComando();
        }
        else{
            Comando();
        }

        /* RegraGC 6.3
            jmp rotFim 
            rotFalso:
        */
        jmp(RotFim);
        File.write("\n\t"+rotFalso+":");

        if(this.registroLido.getToken().equals("else")){
            casaToken("else");
            if(this.registroLido.getToken().equals("{")){
                BlocoComando();
            }
            else{
                Comando();
            }
        }

        /* RegraGC 6.4
            RotFim:
        */
        File.write("\n\t"+RotFim+":");
    }
    
    public void Exp(RegistroLexico regExp) throws Exception{
        RegistroLexico regS1 = new RegistroLexico("expressao");
        ExpS(regS1);

        //Regra 53  ExpTipo = ExpS1.tipo; ExpTamanho = ExpS1.tamanho;
        regExp.setTipo(regS1.getTipo());
        regExp.setTamanho(regS1.getTamanho());

        /* RegraGC 7
            Exp.endereco = S1.endereco
        */
        regExp.setEndereco(regS1.getEndereco());

        String op = "";
        if(this.registroLido.getToken().equals("=")){
            //Regra 54 op = reglex.lexema
            op = this.registroLido.getLexema();
            casaToken("=");
            Exp_RC(regExp, regS1, op);
 
        } else if (this.registroLido.getToken().equals("<>")) {
            //Regra 54 op = reglex.lexema
            op = this.registroLido.getLexema();
            casaToken("<>");
            Exp_RC(regExp, regS1, op);
        } else if (this.registroLido.getToken().equals("<")) {
            //Regra 54 op = reglex.lexema
            op = this.registroLido.getLexema();
            casaToken("<");
            Exp_RC(regExp, regS1, op);
            
        } else if (this.registroLido.getToken().equals(">")) {
            //Regra 54 op = reglex.lexema
            op = this.registroLido.getLexema();
            casaToken(">");
            Exp_RC(regExp, regS1, op);
            
        } else if (this.registroLido.getToken().equals("<=")) {
            //Regra 54 op = reglex.lexema
            op = this.registroLido.getLexema();
            casaToken("<=");
            Exp_RC(regExp, regS1, op);
            
        } else if (this.registroLido.getToken().equals(">=")) {
            //Regra 54 op = reglex.lexema
            op = this.registroLido.getLexema();
            casaToken(">=");
            Exp_RC(regExp, regS1, op);
        }
    }

    public void Exp_RC(RegistroLexico regExp, RegistroLexico regS1, String op) throws Exception {
        regExp.setTipo("logico");
        regExp.setTamanho(0);

        RegistroLexico regS2 = new RegistroLexico("expressao");
        ExpS(regS2);

        //Regra 40 
        if(op.equals("=")){
            if (!((regS1.getTipo().equals("string") || regS1.getTipo().equals("caractere")) 
               && (regS2.getTipo().equals("string") || regS2.getTipo().equals("caractere")))){
                if(!regS1.getTipo().equals(regS2.getTipo())){
                    throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
                }
            }
        }
        else if(regS1.getTamanho() > 0 || regS2.getTamanho() > 0){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
        }
        else if(!regS1.getTipo().equals(regS2.getTipo())){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
        }

        /* RegraGC 8
            mov ax, DS:[Exp.endereco]
            mov bx, DS:[S1.endereco]

            cmp ax, bx
            rotVerdadeiro = novoRot();

            Se op == "=" {
                je rotVerdadeiro
            } Se nao se op == "<>" {
                jne rotVerdadeiro
            } Se nao se op == "<" {
                jl rotVerdadeiro
            } Se nao se op == ">" {
                jg rotVerdadeiro
            } Se nao se op == ">=" {
                jge rotVerdadeiro
            } Se nao se op == "<=" {
                jle rotVerdadeiro
            } 

            mov ax, 0

            rotFim = novoRot();
            jmp rotFim
            rotVerdadeiro:

            mov ax, 1
            rotFim: 

            Exp.endereco = novoTemp()
            mov Exp.endereco, DS:[ax]
        */
        mov("ax", String.format("DS:[0%dh]", regExp.getEndereco()));
        mov("bx", String.format("DS:[0%dh]", regS1.getEndereco()));

        cmp("ax", "bx");
        String rotVerdadeiro = novoRot();

        if(op.equals("=")){
            je(rotVerdadeiro);
        } else if(op.equals("<>")){
            jne(rotVerdadeiro);
        } else if(op.equals("<")){
            jl(rotVerdadeiro);
        } else if(op.equals(">")){
            jg(rotVerdadeiro);
        } else if(op.equals(">=")){
            jge(rotVerdadeiro);
        } else if(op.equals("<=")){
            jle(rotVerdadeiro);  
        } 
        mov("ax", 0);
        String rotFim = novoRot();
        jmp(rotFim);
        File.write("\n\t"+rotVerdadeiro+":");
        mov("ax", 1);
        File.write("\n\t"+rotFim+":");

        regExp.setEndereco(novoTemp(regExp));
        mov(regExp.getEndereco()+"", "DS:[ax]");
    }

    public void ExpS(RegistroLexico regExpS) throws Exception{
        String sinal = "";
        String op = "";

        if(this.registroLido.getToken().equals("+")){
        //Regra 36 sinal = reglex.lexema
            sinal = this.registroLido.getLexema();
            casaToken("+");
        }
        else if(this.registroLido.getToken().equals("-")){
        //Regra 36 sinal = reglex.lexema 
            sinal = this.registroLido.getLexema();   
            casaToken("-");
        }
        
        RegistroLexico regT1 = new RegistroLexico("expressao");
        T(regT1);
        /*Regra 47 
            Se sinal != "" && T1.tipo != inteiro
                ERRO
            ExpSTipo = T1.tipo
            ExpSTamanho = T1.tamanho

        */
        if(!sinal.isEmpty() && (!regT1.getTipo().equals("inteiro"))){
            throw new Exception(this.analisadorLexico.getContadorLinha() + "\nerro");
        }
        regExpS.setTipo(regT1.getTipo());
        regExpS.setTamanho(regT1.getTamanho());
        
        /* RegraGC 9
            ExpS.endereco = T1.endereco

            mov ax, DS:[T1.endereco]
            neg ax
            add ax 1
            mov DS:[ExpS.endereco], ax
        */
        regExpS.setEndereco(regT1.getEndereco());
        mov("ax", String.format("DS:[0%dh]", regT1.getEndereco()));
        neg("ax");
        add("ax", 1);
        mov(String.format("DS:[0%dh]", regExpS.getEndereco()), "ax");

        regExpS.setTipo(regT1.getTipo());
        regExpS.setEndereco(regT1.getEndereco());

        while(this.registroLido.getToken().equals("+") || this.registroLido.getToken().equals("-") || this.registroLido.getToken().equals("or")){
            if(this.registroLido.getToken().equals("+")){
                //Regra 54 op = reglex.lexema
                op = this.registroLido.getLexema();
                casaToken("+");
            } else if(this.registroLido.getToken().equals("-")){
                //Regra 54 op = reglex.lexema
                op = this.registroLido.getLexema();
                casaToken("-");
            } else {
                //Regra 54 op = reglex.lexema
                op = this.registroLido.getLexema();
                casaToken("or");
            }
            RegistroLexico regT2 = new RegistroLexico("expressao");
            T(regT2);
            /* Regra 33 
                Se op == "+" && (T1Tipo != inteiro  || T2.tipo != inteiro) 
                || op == "-" && (T1Tipo != inteiro || T2.tipo != inteiro)
                || op == "or" && (T1Tipo != logico || T2.tipo != logico)
                || T1Tipo != T2.tipo                     
                    ERRO: tipos incompatives
            */
            if(op.equals("+") && (!regT1.getTipo().equals("inteiro") || !regT2.getTipo().equals("inteiro"))
            || op.equals("-") && (!regT1.getTipo().equals("inteiro") || !regT2.getTipo().equals("inteiro"))
            || op.equals("or") && (!regT1.getTipo().equals("logico") || !regT2.getTipo().equals("logico"))
            || (!regT1.getTipo().equals(regT2.getTipo()))){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }

            //Regra 34 Se T2.tamanho > 0 || T1Tamanho > 0 && op != vazio ERRO:classe de identificador incompativel [lex].
            if(regT2.getTamanho() > 0 || regT1.getTamanho() > 0){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regT2.getLexema()+"].");
            }

            /* RegraGC 10
                mov ax, DS:[ExpS.endereco]
                mov bx, DS:[T2.endereco]


                Se op == "+" {
                    add ax bx
                } Se nao se op == "-" {
                    neg bx
                add ax bx
                } Se nao se op == "or" {
                    imul bx
                    neg ax
                add ax 1
                }
                ExpS.endereco = novoTemp()
                mov ExpS.endereco, DS:[ax]
            */
            mov("ax", String.format("DS:[0%dh]", regExpS.getEndereco()));
            mov("bx", String.format("DS:[0%dh]", regT2.getEndereco()));

            if(op.equals("+")){
                add("ax", "bx");
            }
            else if(op.equals("-")){
                neg("bx");
                add("ax", "bx");   
            }
            else if(op.equals("or")){
                imul("bx");
                neg("ax");
                add("ax", 1);
            }

            regExpS.setEndereco(novoTemp(regExpS));
            mov(regExpS.getEndereco()+"", "DS:[ax]");
        }
    }

    public void T(RegistroLexico regT) throws Exception {
        String op = "";
        RegistroLexico regF1 = new RegistroLexico("expressao");
        F(regF1);

        //Regra 52 TTipo = F1.tipo; TTamanho = F1.tamanho;
        regT.setTipo(regF1.getTipo());
        regT.setTamanho(regF1.getTamanho());

        /* RegraGC 11
            T.endereco = F1.endereco
        */
        regT.setEndereco(regF1.getEndereco());        

        while(  this.registroLido.getToken().equals("*") || this.registroLido.getToken().equals("and") || 
                this.registroLido.getToken().equals("/") || this.registroLido.getToken().equals("%")){
            if(this.registroLido.getToken().equals("*")){
                //Regra 54 op = reglex.lexema
                op = this.registroLido.getLexema();
                casaToken("*");
            } else if(this.registroLido.getToken().equals("and")){
                //Regra 54 op = reglex.lexema
                op = this.registroLido.getLexema();
                casaToken("and");
            } else if(this.registroLido.getToken().equals("/")){
                //Regra 54 op = reglex.lexema
                op = this.registroLido.getLexema();
                casaToken("/");
            } else {
                //Regra 54 op = reglex.lexema
                op = this.registroLido.getLexema();
                casaToken("%");
            }
            
            RegistroLexico regF2 = new RegistroLexico("expressao");
            F(regF2);

            /* Regra 30 
                Se op == "*" && (F1Tipo != inteiro || F2.tipo != inteiro)
                || op == "and" && (F1Tipo != logico || F2.tipo != logico)
                || op == "/" && ( F1Tipo != inteiro ||  F2.tipo != inteiro)
                || op == "%" && ( F1Tipo != inteiro ||  F2.tipo != inteiro)
                || F1Tipo != F2.tipo 
                    ERRO (tipos incompativeis)

                TTipo = F1.tipo
                TTamanho = F1.tamanho
            */
            if(op.equals("*") && (!regF1.getTipo().equals("inteiro") || !regF2.getTipo().equals("inteiro"))
            || op.equals("and") && (!regF1.getTipo().equals("logico") || !regF2.getTipo().equals("logico"))
            || op.equals("/") && (!regF1.getTipo().equals("inteiro") || !regF2.getTipo().equals("inteiro"))
            || op.equals("%") && (!regF1.getTipo().equals("inteiro") || !regF2.getTipo().equals("inteiro"))
            || (!regF1.getTipo().equals(regF2.getTipo()))){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }

            regT.setTipo(regF1.getTipo());
            regT.setTamanho(regF1.getTamanho());

            //Regra 31: Se F2Tamanho > 0 || F1Tamanho > 0 ERRO:classe de identificador incompativel [lex].
            if(regF2.getTamanho() > 0 || (regF1.getTamanho() > 0)){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nclasse de identificador incompativel ["+regF2.getLexema()+"].");
            }

            /* RegraGC 12
                mov ax, DS:[T.endereco]
                mov bx, DS:[F2.endereco]

                Se op == "*" {
                    imul bx
                } Se nao se op == "/" {
                    idiv bx
                } Se nao se op == "and" {
                    imul bx
                } Se nao se op == "%" {
                    idiv bx
                mov ax dx
                }
                T.endereco = novoTemp()
                mov T.endereco, DS:[ax]
            */
            mov("ax", String.format("DS:[0%dh]", regT.getEndereco()));
            mov("bx", String.format("DS:[0%dh]", regF2.getEndereco()));

            if (op.equals("*")){
                imul("bx");
            }
            if (op.equals("/")){
                idiv("bx");
            }
            if(op.equals("and")){
                imul("bx");
            }
            if(op.equals("%")){
                idiv("bx");
                mov("ax", "dx");
            }
            regT.setEndereco(novoTemp(regT));
            mov(regT.getEndereco() + "", "DS:[ax]");
        }
    }

    public void F(RegistroLexico regF) throws Exception {
        if (this.registroLido.getToken().equals("id")){
            RegistroLexico regId = this.registroLido;            
            casaToken("id");
            //Regra 3: Se id.classe == vazio ERRO: identificador nao declarado [lex].
            if(regId.getClasse().equals("vazio")){
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\nidentificador nao declarado ["+regId.getLexema()+"].");
            }
            //Regra 22: FTipo = id.tipo ; FTamanho = id.tamanho
            regF.setTipo(regId.getTipo());
            regF.setTamanho(regId.getTamanho());

            /* RegraGC 13
                F.endereco = id.endereco
            */
            regF.setEndereco(regId.getEndereco());

            if(this.registroLido.getToken().equals("[")){
                casaToken("[");

                /* Regra 25: 
                    Se idTamanho == 0 ERRO 
                    Se ExpTipo != inteiro ERRO 
                    FTamanho = 0
                */
                if(regId.getTamanho() == 0){
                    throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
                }
                RegistroLexico regExp = new RegistroLexico("expressao");
                Exp(regExp);
                if(!regExp.getTipo().equals("inteiro")){
                    throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
                }
                regF.setTamanho(0);
                casaToken("]");

                /* RegraGC 14
                    F.endereco = novoTemp()
                    mov ax, DS:[Exp.endereco]

                    Se Exp.tipo == inteiro
                        add ax, DS:[Exp.endereco]

                    add ax, DS:[id.endereco]
                    mov F.endereco, DS:[ax]
                */
                regF.setEndereco(novoTemp(regF));
                mov("ax", String.format("DS:[0%dh]", regExp.getEndereco()));

                if(regExp.getTipo().equals("inteiro"))
                    add("ax", String.format("DS:[0%dh]", regExp.getEndereco()));

                add("ax", String.format("%d", regId.getEndereco()));
                mov(regF.getEndereco() + "", "DS:[ax]");
            }
        } else if (this.registroLido.getToken().equals("const")){
            //Regra 24: FTipo = const.tipo; FTamanho = const.tamanho;
            RegistroLexico regConst = this.registroLido;
            casaToken("const");
            regF.setTipo(regConst.getTipo());
            regF.setTamanho(regConst.getTamanho());

            /* RegraGC 15
                Se const.tipo == string
                    dseg SEGMENT PUBLIC
                    byte regConst.getLexema()$
                    dseg ENDS
                    F.endereco = novoTemp()
                Se nao
                    F.endereco = novoTemp()
                    mov ax, const.lexema
                mov DS:[F.endereco], ax
            */
            if (regConst.getTipo().equals("string")){
                File.write("\ndseg SEGMENT PUBLIC");
                File.write("\n\tbyte " + regConst.getLexema()+"$");
                File.write("\ndseg ENDS");
                regF.setEndereco(novoTemp(regF));
                endereco = endereco + regF.getEndereco();
            }
            else{
                regF.setEndereco(novoTemp(regF));
                mov("ax", regConst.getLexema());
                mov(String.format("DS:[0%dh]", regF.getEndereco()), "ax");
            }
        } else if (this.registroLido.getToken().equals("not")){
            casaToken("not");
            //Regra 26: Se F1.tipo == logico F1.tamanho == 0 ENTAO FTipo = F1.tipo ; FTamanho = F1.tamanho;
            //Se nao ERRO tipos incompativeis. 
            RegistroLexico regF1 = new RegistroLexico("espressao");  
            F(regF1);
            if(regF1.getTipo().equals("logico") && regF1.getTamanho() == 0){
                regF.setTipo(regF1.getTipo());
                regF.setTamanho(regF1.getTamanho());
            } else {
                throw new Exception(this.analisadorLexico.getContadorLinha() + "\ntipos incompativeis.");
            }
            
            /* RegraGC 16
                mov ax, DS:[F1.endereco]
                neg ax
                add ax 1
                mov DS:[F.endereco], ax
            */
            regF.setEndereco(novoTemp(regF1));
            mov("ax", String.format("DS:[0%dh]", regF1.getEndereco()));
            neg("ax");
            add("ax", 1);
            mov(String.format("DS:[0%dh]", regF.getEndereco()), "ax");
        
        } else {
            casaToken("(");
            //Regra 28: FTipo = Exp.tipo ; FTamanho = Exp.tamanho; 
            RegistroLexico regExp = new RegistroLexico("expressao");
            Exp(regExp);
            regF.setTipo(regExp.getTipo());
            regF.setTamanho(regExp.getTamanho());

            /* RegraGC 17
                F.endereco = Exp.endereco
            */
            regF.setEndereco(regExp.getEndereco());
            
            casaToken(")");
        }
    }

    /** Geracao de Codigo **/

    // Retorna um novo endereço na memória para um novo registro temporário
    public int novoTemp(RegistroLexico regLex){
        int incremento = (regLex.getTamanho() > 0) ? regLex.getTamanho() : 1;
        
        if(regLex.getTipo().equals("inteiro"))
            incremento *= 2;

        int temp = this.enderecoTemporario;
        this.enderecoTemporario = this.enderecoTemporario + (incremento);
        return temp; 
    }

    // Retorna um novo rótulo
    public String novoRot(){
        this.novoRot = this.novoRot + 1; 
        String novoRot = "R"+String.valueOf(this.novoRot);
        return novoRot;
    }

    // Move o conteúdo de rO para rD
    public void mov(String rD, String rO){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tmov %s, %s", rD, rO);
        File.write(codigoGerado);
    }

    // Move um valor imediato para reg
    public void mov(String reg, int imed){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tmov %s, %d", reg, imed);
        File.write(codigoGerado);
    }

    // Nega o valor presente no registrador neg
    public void neg(String reg){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tneg %s", reg);
        File.write(codigoGerado);
    }

    // Soma o valor de imed no registrador rD
    public void add(String rD, int imed){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tadd %s, %d", rD, imed);
        File.write(codigoGerado);
    }

    // Soma o valor de rO em rD
    public void add(String rD, String rO)
    {
        String codigoGerado = "";
        codigoGerado = String.format("\n\tadd %s, %s", rD, rO);
        File.write(codigoGerado);
    }

    // Faz a multiplicacao do valor presente em ax por reg
    public void imul(String reg){
        String codigoGerado = "";
        codigoGerado = String.format("\n\timul %s", reg);
        File.write(codigoGerado);
    }

    // Faz a divisao do valor presente em ax por reg
    public void idiv(String reg){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tidiv %s", reg);
        File.write(codigoGerado);
    }

    // Faz a comparacao entre r1 e r2 para ser utilizada posteriormente
    public void cmp(String r1, String r2){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tcmp %s, %s", r1, r2);
        File.write(codigoGerado);
    }

    // Pula para o rotulo dest caso r1 > r2 na comparacao anterior
    public void jg(String dest){
        String codigoGerado = "";
        codigoGerado = String.format("\tjg %s\n", dest);
        File.write(codigoGerado);
    }

    // Pula para o rotulo dest caso r1 >= r2 na comparacao anterior
    public void jge(String dest){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tjge %s", dest);
        File.write(codigoGerado);
    }

    // Pula para o rotulo dest caso r1 < r2 na comparacao anterior
    public void jl(String dest){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tjl %s", dest);
        File.write(codigoGerado);
    }

    // Pula para o rotulo dest caso r1 <= r2 na comparacao anterior
    public void jle(String dest){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tjle %s", dest);
        File.write(codigoGerado);
    }

    // Pula para o rotulo dest caso r1 = r2 na comparacao anterior
    public void je(String dest){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tje %s", dest);
        File.write(codigoGerado);
    }

    // Pula para o rotulo dest caso r1 != r2 na comparacao anterior
    public void jne(String dest){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tjne %s", dest);
        File.write(codigoGerado);
    }

    // Pula para o rotulo dest
    public void jmp(String dest){
        String codigoGerado = "";
        codigoGerado = String.format("\n\tjmp %s", dest);
        File.write(codigoGerado);
    }

    // Realiza a criacao de variaveis / constantes do codigo
    public void geraVariavel(RegistroLexico regId, RegistroLexico regExp){
        regId.setEndereco(this.endereco);

        String codigoGerado = "";
        if (regId.getTipo().equals("inteiro")){
            codigoGerado = "\tsword "; // Se a variavel / constante for inteira, utiliza sword pois precisa de 2 bytes

            if(regId.getTamanho() > 0 ){
                codigoGerado = codigoGerado + "0" + Integer.toHexString(regId.getTamanho()) + "h"  + " DUP (?)"; // Transforma o tamanho em numero hexadecimal
                this.endereco = this.endereco + (regId.getTamanho() * 2); // Ocupa 2 bytes
            } else {
                if(regExp != null){
                    codigoGerado = codigoGerado + regExp.getLexema();
                } else {
                    codigoGerado = codigoGerado + "?"; // Caso nao tenha sido atribuido
                } 
                this.endereco = this.endereco + 2; // Ocupa 2 bytes     
            }            
        }
        if (regId.getTipo().equals("caractere")){
            codigoGerado = "\tbyte "; // Se a variavel / constante for inteira, utiliza byte pois precisa de 1 byte
            
            if(regId.getTamanho() > 0 ){
                if(regExp != null){                    
                    codigoGerado = "\tdseg SEGMENT PUBLIC\n";
                    codigoGerado = codigoGerado + "\t" + regExp.getLexema() + "$" + "\n";
                    codigoGerado = codigoGerado + "dseg ENDS\n";
                } else {
                    codigoGerado = codigoGerado + "0" + Integer.toHexString(regId.getTamanho())+ "h" + " DUP (?)"; // Transforma o tamanho em numero hexadecimal
                }
                this.endereco = this.endereco + regId.getTamanho();
            }  else {
                if(regExp != null){
                    codigoGerado = codigoGerado + regExp.getLexema();
                } else {
                    codigoGerado = codigoGerado + "?"; // Caso nao tenha sido atribuido
                } 
                this.endereco = this.endereco + 1;
            }
        }
        if (regId.getTipo().equals("logico")){
            codigoGerado = "\tbyte "; // Se a variavel / constante for inteira, utiliza byte pois precisa de 1 byte

            if(regId.getTamanho() > 0){
                codigoGerado = codigoGerado + "0" + Integer.toHexString(regId.getTamanho()) + "h" + " DUP (?)"; // Transforma o tamanho em numero hexadecimal
                this.endereco = this.endereco + regId.getTamanho();
            }
            else{
                if(regExp != null){
                    codigoGerado = codigoGerado + regExp.getLexema();
                } else {
                    codigoGerado = codigoGerado + "?"; // Caso nao tenha sido atribuido
                } 
                this.endereco = this.endereco + 1;
            }
        }
        
        File.write("\n" + codigoGerado);
    }
}

class File
{
    private static BufferedWriter buffer;

    // Cria o arquivo destino do gerador de codigo e insere o cabecalho
    public static void open()
    {
        try
        {
            buffer = new BufferedWriter(new FileWriter("ASM.txt", false));
            buffer.write("");

            buffer = new BufferedWriter(new FileWriter("ASM.txt", true));

            // Parte inicial do arquivo ASM
            File.write("sseg SEGMENT STACK ;inicio seg. pilha");
            File.write("\n\tbyte 4000h DUP(?)");
            File.write("\nsseg ENDS ;fim seg. pilha\n");
            File.write("\ndseg SEGMENT PUBLIC ;inicio seg. dados");
            File.write("\n\tbyte 4000h DUP(?) ;temporarios");
        }
        catch(Exception ex)
        {
            System.out.println("Open file error");
        }
    }

    // Escreve no arquivo destino do gerador de codigo
    public static void write(String s)
    {
        try
        {
            buffer.write(s);
        }
        catch(Exception ex)
        {
            System.out.println("Write error");
        }
    }

    // Fecha o arquivo destino do gerador de codigo
    public static void close()
    {
        try
        {
            if (buffer != null)
            {
                buffer.close();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Close file error");
        }
    }
}
