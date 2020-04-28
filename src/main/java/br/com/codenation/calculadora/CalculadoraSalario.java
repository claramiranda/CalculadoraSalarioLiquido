package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBruto) {
		double salarioBase = calcularInss(salarioBruto);
		salarioBase = calcularIRRF(salarioBase);

		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		return Math.round(salarioBase);
	}

	private double calcularIRRF(double salarioBase){
		double desconto = 0;

		if (salarioBase <= 1039.00){
			//System.out.println("Isento IRRF - R$" + salarioBase);
			return 0.0;
		}
		else if (salarioBase <= 3000.00 && salarioBase > 1039.00){
			//System.out.println("IRRF R$"+salarioBase+" - Isento do INSS");
			return salarioBase;
			//return Math.round(salarioBase);
		}
		else if (salarioBase > 3000.00 && salarioBase <= 6000.00){
			desconto = (salarioBase * 7.5) / 100;
			//System.out.println("IRRF R$"+salarioBase+" - Desconto de 7.5% - R$" + desconto);
			return salarioBase - desconto;

		}
		else{
			desconto = (salarioBase * 15) / 100;
			//System.out.println("IRRF R$"+salarioBase+" - Desconto de 15% - R$" + desconto);
			return salarioBase - desconto;
		}

	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBruto) {
		double salarioBase = 0, desconto = 0;

		if(salarioBruto <= 1500.00){
			desconto = (salarioBruto * 8) / 100;
			salarioBase = salarioBruto - desconto;
			//System.out.println("INSS Faixa 1 - Desconto R$" + desconto);
			return salarioBase;
		}
		else if (salarioBruto > 1500.00 && salarioBruto <= 4000.00){
			desconto =  (salarioBruto * 9) / 100;
			//System.out.println("Faixa 2 - Desconto R$" + desconto);
			salarioBase = salarioBruto - desconto;
			return salarioBase;
		}
		else{
			desconto = (salarioBruto * 11) / 100;
			salarioBase = salarioBruto - desconto;
			//System.out.println("Faixa 3 - Desconto R$" + desconto);
			return salarioBase;
		}

	}

}
