/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static final int RESET_TIME = 10_000; // tempo em milissegundos
    private static boolean isGreen = true; // cor inicial do farol
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        // define a tarefa que será executada a cada 10 segundos
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                isGreen = true; // reseta o farol para verde
                System.out.println("Farol resetado para verde");
            }
        };
        
        // inicia a tarefa que será executada a cada 10 segundos
        timer.schedule(task, RESET_TIME, RESET_TIME);
        
        // loop principal do programa
        while (true) {
            // obtém o tempo inicial
            long start = System.currentTimeMillis();
            
            // simula a ação do usuário (espera por um tempo aleatório)
            try {
                Thread.sleep((long) (Math.random() * 20_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // obtém o tempo final e calcula a diferença
            long end = System.currentTimeMillis();
            long diff = end - start;
            
            // verifica se o usuário demorou mais de 10 segundos
            if (diff > 10_000) {
                isGreen = false; // muda o farol para vermelho
                System.out.println("Usuário demorou " + diff / 1000 + " segundos, farol vermelho");
            } else {
                System.out.println("Usuário demorou " + diff / 1000 + " segundos, farol verde");
            }
        }
    }
}
