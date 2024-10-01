public class ifdanf {
    private No encontrarElemento(No noAtual, int valorInformado) {
        if (noAtual == null) return null;

        if (valorInformado > noAtual.valor) {
            if (noAtual.direita != null) {
                if (noAtual.direita.valor == valorInformado) {
                    return noAtual;
                }
            }
        } else {
            if (noAtual.esquerda != null) {
                if (noAtual.esquerda.valor == valorInformado) {
                    return noAtual;
                }
            }
        }

        if (noAtual.valor > valorInformado) {
            return encontrarElemento(noAtual.direita, valorInformado);
        }
        if (valorInformado > noAtual.valor) {
            return encontrarElemento(noAtual.esquerda, valorInformado);
        }

        return null;
    }

    private No noMaisAEsquerda(No pai, No filho) {
        if (filho.esquerda == null) {
            return pai;
        }

        return noMaisAEsquerda(filho, filho.esquerda);
    }

    private No noMaisADireita(No pai, No filho) {
        if (filho.direita == null) {
            return pai;
        }

        return noMaisADireita(pai, filho.direita);
    }
    
    public boolean remove(int valorInformado) {
        if (root != null) {
            No pai;
            No auxNo;

            if (root.valor == valorInformado) {
                if (root.esquerda == null && root.esquerda == null) {
                    root = null;
                } else if (root.esquerda == null) {
                    root = root.direita;
                } else if (root.direita == null) {
                    root = root.esquerda;
                } else {
                    No noDireitaEsquerda = noMaisAEsquerda(root, root.direita);
                    No substituto = noDireitaEsquerda.esquerda;
                
                    if (substituto != null) {
                        noDireitaEsquerda.esquerda = substituto.direita;
                        substituto.direita = root.direita;
                        substituto.esquerda = root.esquerda;
                    } else {
                        substituto = root.direita;
                        substituto.esquerda = root.esquerda;
                    }

                
                    root = substituto;
                }            
                return true;
            } else {
                pai = encontrarElemento(root, valorInformado);
                auxNo = root;

                if (valorInformado > pai.valor) {
                    auxNo = pai.direita;
                }
                else {
                    auxNo = pai.esquerda;
                }

                if (auxNo.direita == null && auxNo.esquerda == null) { // Caso 1 FOLHA
                    if (valorInformado > pai.valor) {
                        pai.direita = null;
                    }
                    else {
                        pai.esquerda = null;
                    }

                    return true;
                } else {
                    if (auxNo.direita == null) { //Caso 2 – Tem UM FILHO
                        if (valorInformado > pai.valor) {
                            pai.direita = auxNo.esquerda;
                        } else {
                            pai.esquerda = auxNo.esquerda;
                        }
                    } else if (auxNo.esquerda == null) {
                        if (valorInformado > pai.valor) {
                            pai.direita = auxNo.direita;
                        } else {
                            pai.esquerda = auxNo.direita;
                        }
    
                        return true;
                    }
                }

                if (auxNo.esquerda != null && auxNo.direita != null) { // Caso 3 - DOIS FILHOS
                    No paiRL = noMaisAEsquerda(auxNo, auxNo.direita);
                    No substituto = paiRL.direita;
    
                    substituto.direita = auxNo.direita;
                    substituto.esquerda = auxNo.esquerda;
    
                    auxNo.esquerda = null;
                    auxNo.direita = null;
    
                    if (valorInformado > pai.valor) {
                        pai.direita = substituto;
                    } else if (valorInformado < pai.valor) {
                        pai.esquerda = substituto;
                    } else {
                        pai = substituto;
                    }

                    return true;
                }
            }
        }
        return false;
    }
}
