
/**
 * Write a description of class Funcionario here.
 *
 * @author João e Blu
 * @version (a version number or a date)
 */
public class Funcionario
{
    private String nome;
    private String cpf;
    private float salarioBase;
    private int anosDeServico;

    public Funcionario(String nome, String cpf)
    {
        this(nome, cpf, 0, 0);
    }

    public Funcionario(String nome, String cpf, float salarioBase)
    {
        this(nome, cpf, salarioBase, 0);
    }

    public Funcionario(String nome, String cpf, float salarioBase, int anosDeServico)
    {
        this.nome          = nome;
        this.cpf           = cpf;
        this.salarioBase   = salarioBase;
        this.anosDeServico = anosDeServico;
    }

    private float calcularSalarioPorSenioridade(float salarioBase, int anosDeServico)
    {
        float salario = salarioBase;

        float fatorDeSenioridade = 1.0e3f;
        float taxaDeCrescimento = 0.04f;

        if(anosDeServico > 5) {
            salario += fatorDeSenioridade * (float)anosDeServico;
        } else if(3 <= anosDeServico && anosDeServico <= 5) {
            float multiplicador = 1 + taxaDeCrescimento;

            for(int i = 0; i < anosDeServico; i++) {
                multiplicador *= multiplicador;
            }

            salario *= multiplicador;
        }

        return salario;
    }

    private float aplicarDescontoPorFaltas(float salario, int numeroDeDiasDeFalta)
    {
        float salarioDescontado = salario;

        if(numeroDeDiasDeFalta > 0 && numeroDeDiasDeFalta < 30) {
            for(int i = 0; i < numeroDeDiasDeFalta; i++) {
                float descontoPorFalta = salarioDescontado * 0.005f;
                salarioDescontado -= descontoPorFalta;
            }
        }

        return salarioDescontado;
    }

    public float calcularSalario(int numeroDeDiasDeFalta)
    {
        return this.calcularSalario(this.salarioBase, this.anosDeServico, numeroDeDiasDeFalta);
    }

    public float calcularSalario(float salarioBase, int anosDeServico, int numeroDeDiasDeFalta)
    {
        float salario = this.calcularSalarioPorSenioridade(salarioBase, anosDeServico);
        float salarioDescontado = this.aplicarDescontoPorFaltas(salario, numeroDeDiasDeFalta);

        return salarioDescontado;
    }

    public static void main(String[] args)
    {
        System.out.println("teste: criar funcionarios");

        Funcionario funcionario1 = new Funcionario("Robert", "8712871121");
        Funcionario funcionario2 = new Funcionario("Jose", "19827319827", 1000);
        Funcionario funcionario3 = new Funcionario("Helena", "9085749587", 1500, 4);
        Funcionario funcionario4 = new Funcionario("Maria", "908587621587", 1500, 6);

        // TODO: Imprimir informações dos funcionários

    }

}
