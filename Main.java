
/**
 * Write a description of class Main here.
 *
 * @author João e Blu
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("teste: criar funcionarios");

        Funcionario funcionario1 = new Funcionario("Robert", "8712871121");
        Funcionario funcionario2 = new Funcionario("Jose", "19827319827", 1000f);
        Funcionario funcionario3 = new Funcionario("Helena", "9085749587", 1500f, 4);
        Funcionario funcionario4 = new Funcionario("Maria", "908587621587", 1500f, 6);

        //Calcular o salario com diferentes tempos de serviço
        float salario1 = funcionario1.calcularSalario(0);
        float salario2 = funcionario2.calcularSalario(0);

        System.out.println(salario1);
        System.out.println(salario2);

        //Calcular o salario com diferentes quantidades de faltas
        float salario3 = funcionario3.calcularSalario(0);
        float salario4 = funcionario4.calcularSalario(13);

        System.out.println(salario3);
        System.out.println(salario4);

        //Calcular com número inválido de faltas
        float salario5 = funcionario4.calcularSalario(31);

        System.out.println(salario5);

        //Dados antes da alteração
        funcionario1.apresentarDados();
        funcionario2.apresentarDados();

        //Atualizar os dados das duas maneiras
        funcionario1.atualizarDados("Robert", 1000f);
        funcionario2.atualizarDados("Jose", 2500.5f, 2);

        //Dados após as alterações
        funcionario1.apresentarDados();
        funcionario2.apresentarDados();
    }
}
