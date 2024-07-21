public class MatrizQuadradaOtimizada extends Matriz{
    MatrizQuadradaOtimizada(){
		super(2,2);
	}
	MatrizQuadradaOtimizada(int ordem){
		super(ordem,ordem);
	}
	public int getOrdem(){
		return this.getNumeroLinhas();
	}
    public int linhaComMaisZeros(){
        int contColunas, contLinhas, maxZerosLinha, linhaEscolhida, qntdZerosLinhas;
        maxZerosLinha = -1;
        linhaEscolhida = -1;
        qntdZerosLinhas = 0;
        for (contLinhas = 0; contLinhas < this.getNumeroLinhas(); contLinhas++){
            for (contColunas = 0; contColunas < this.getNumeroColunas(); contColunas++) {
                if (getElemento(contLinhas, contColunas) == 0) {
                    qntdZerosLinhas++;
                }
            }
            if (qntdZerosLinhas > maxZerosLinha) {
                maxZerosLinha = qntdZerosLinhas;
                linhaEscolhida = contLinhas;
            }
            qntdZerosLinhas = 0;
        }
		return linhaEscolhida;
    }
    public int qntdZerosNaMelhorLinha(){
        int contColunas, contLinhas, maxZerosLinha, linhaEscolhida, qntdZerosLinhas;
        maxZerosLinha = -1;
        linhaEscolhida = -1;
        qntdZerosLinhas = 0;
        for (contLinhas = 0; contLinhas < this.getNumeroLinhas(); contLinhas++){
            for (contColunas = 0; contColunas < this.getNumeroColunas(); contColunas++) {
                if (getElemento(contLinhas, contColunas) == 0) {
                    qntdZerosLinhas++;
                }
            }
            if (qntdZerosLinhas > maxZerosLinha) {
                maxZerosLinha = qntdZerosLinhas;
                linhaEscolhida = contLinhas;
            }
            qntdZerosLinhas = 0;
        }
		return maxZerosLinha;
	}
    public int colunaComMaisZeros(){
        int contColunas, contLinhas, qntdZerosColunas, maxZerosColuna, colunaComMaisZeros;
        maxZerosColuna = -1;
        colunaComMaisZeros = -1;
        qntdZerosColunas = 0;
        for (contColunas = 0; contColunas < this.getNumeroColunas(); contColunas++) {
            for (contLinhas = 0; contLinhas < this.getNumeroLinhas(); contLinhas++) {
                if (this.getElemento(contLinhas, contColunas) == 0) {
                    qntdZerosColunas++;
                }
            }
            if (qntdZerosColunas > maxZerosColuna) {
                maxZerosColuna = qntdZerosColunas;
                colunaComMaisZeros = contColunas;
            }
            qntdZerosColunas = 0;
        }
		return colunaComMaisZeros;
    }
    public int qntdZerosNaMelhorColuna(){
        int contColunas, contLinhas, qntdZerosColunas, maxZeroColuna, colunaComMaisZeros;
        maxZeroColuna = -1;
        colunaComMaisZeros = -1;
        qntdZerosColunas = 0;
        for (contColunas = 0; contColunas < this.getNumeroColunas(); contColunas++) {
            for (contLinhas = 0; contLinhas < this.getNumeroLinhas(); contLinhas++) {
                if (this.getElemento(contLinhas, contColunas) == 0) {
                    qntdZerosColunas++;
                }
            }
            if (qntdZerosColunas > maxZeroColuna) {
                maxZeroColuna = qntdZerosColunas;
                colunaComMaisZeros = contColunas;
            }
            qntdZerosColunas = 0;
        }
		return maxZeroColuna;
    }
    public void copiaMatrizGrandeParaMatrizPequena(MatrizQuadradaOtimizada matriz, MatrizQuadradaOtimizada matPequena, int linhaProibida, int colunaProibida){
		int contLG,contCG,contLP,contCP;
		contLP = 0;	
		for(contLG =0; contLG < matriz.getOrdem(); contLG++){
			if(contLG != linhaProibida){
				contCP = 0;
				for(contCG =0; contCG < matriz.getOrdem(); contCG++){
					if(contCG != colunaProibida){	
								matPequena.setElemento(contLP,contCP,matriz.getElemento(contLG, contCG));
						contCP++;
					}
				}
				contLP++;
			}
		}
	}
	public float detLaPlaceRecursivo(MatrizQuadradaOtimizada mat){
		MatrizQuadradaOtimizada matLinha = new MatrizQuadradaOtimizada(mat.getOrdem()-1);	
		float acum = 0.0f;
		int linha = 0;
        int coluna = 0;
        int cofator = 0;
		if(qntdZerosNaMelhorLinha() >= qntdZerosNaMelhorColuna()){
            for(int cont = 0; cont < mat.getOrdem(); cont++){
                linha = linhaComMaisZeros();
                matLinha.copiaMatrizGrandeParaMatrizPequena(mat,matLinha,linha,cont);
                cofator = mat.getElemento(linhaComMaisZeros(), cont);
                acum +=  cofator * Math.pow(-1, linha + cont) * detLaPlace(matLinha);
            }
        }
        else if(qntdZerosNaMelhorColuna() > qntdZerosNaMelhorLinha()){
            for(int cont = 0; cont < mat.getOrdem(); cont++){
                coluna  = colunaComMaisZeros();
                matLinha.copiaMatrizGrandeParaMatrizPequena(mat,matLinha,cont,coluna);
                cofator = mat.getElemento(cont, colunaComMaisZeros());
                acum +=  cofator * Math.pow(-1, linha + cont) * detLaPlace(matLinha);
            }
        }
            
		return acum;	
	}
	public float detLaPlace(MatrizQuadradaOtimizada mat){
		int contOrdem;
		float resultado = 0;
		if(mat.getOrdem() == 1){
			resultado = mat.getElemento(0,0);
		}
		else{
			resultado = mat.detLaPlaceRecursivo(mat);
		}
		return resultado;
	}
	public float detLaPlace(){
		return this.detLaPlace(this);
	}
}
