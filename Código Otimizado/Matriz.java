import java.util.Random;
import java.util.Scanner;
class Matriz{
    private int[][]mat;
	private int numeroLinhas;
	private int numeroColunas;
	
	Matriz(){
		this(3,3);
	}
	Matriz(int numeroLinhas, int numeroColunas){
		this.setNumeroLinhas(numeroLinhas);
		this.setNumeroColunas(numeroColunas);
		mat = new int[this.getNumeroLinhas()][this.getNumeroColunas()];
	}
	public int getNumeroLinhas(){
		return this.numeroLinhas;
	}
	
	public void setNumeroLinhas(int novoValor){
		this.numeroLinhas = novoValor;
	}
	
	public int getNumeroColunas(){
		return this.numeroColunas;
	}
	
	public void setNumeroColunas(int novoValor){
		this.numeroColunas = novoValor;
	}
	
	
	public int getElemento(int indexLinha, int indexColuna){
		return this.mat [indexLinha] [indexColuna];
	}
	
	public void setElemento(int indexLinha, int indexColuna, int novoValor){
		this.mat [indexLinha] [indexColuna] = novoValor;
	}
    public void inicializaRandomico(){
		int contC,contL,entrada;
		Random gerador = new Random(0);
		for(contL = 0; contL < this.getNumeroLinhas(); contL++){
			for(contC = 0; contC < this.getNumeroColunas(); contC++){
				entrada = gerador.nextInt((this.getNumeroLinhas() * this.getNumeroColunas())+1);
				this.setElemento(contL, contC, entrada);
			}
		}
	}

    public void imprime(){
		int contC,contL;
		for(contL = 0; contL < this.getNumeroLinhas(); contL++){
			for(contC = 0; contC < this.getNumeroColunas(); contC++){
				System.out.print(" "+this.getElemento(contL, contC));
			}
			System.out.println();
		}
	}
	public void inicializaManual(){
		Scanner ler = new Scanner(System.in);
		int entrada;
		for(int contLinha = 0; contLinha < this.getNumeroLinhas(); contLinha++){
			for(int contColuna = 0; contColuna < this.getNumeroColunas(); contColuna++){
				entrada = ler.nextInt();
				this.setElemento(contLinha, contColuna, entrada);
			}
		}
	}
}
