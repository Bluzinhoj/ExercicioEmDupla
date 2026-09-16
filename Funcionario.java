
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

    private float calcularSalarioPorSenioridade()
    {
        float salario = this.salarioBase;

        float fatorDeSenioridade = 1.0e3f;
        float taxaDeCrescimento = 0.04f;

        if(this.anosDeServico > 5) {
            salario += fatorDeSenioridade * (float)this.anosDeServico;
        } else if(3 <= this.anosDeServico && this.anosDeServico <= 5) {
            float multiplicador = 1 + taxaDeCrescimento;

            for(int i = 0; i < this.anosDeServico; i++) {
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
    
    public void atualizarDados(String nome, float salarioBase){
        this.nome = nome;
        this.salarioBase = salarioBase;
    }
    
    public void atualizarDados(String nome, float salarioBase, int anosDeServico){
        this.atualizarDados(nome, salarioBase);
        this.anosDeServico = anosDeServico;
    }
    
    public void apresentarDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Salario Base: " + this.salarioBase);
        System.out.println("Anos de Serviço: " + this.anosDeServico);
    }
}
