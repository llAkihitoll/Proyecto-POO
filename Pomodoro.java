public class Pomodoro {
// atributos privados que almacenan los intervalos de trabajo y descanso
        private int intervaloTrabajo;
        private int intervaloDescanso;

// constructor que inicializa los atributos como parametros
        public Pomodoro(int intervaloTrabajo, int intervaloDescanso) {
            this.intervaloTrabajo = intervaloTrabajo;
            this.intervaloDescanso = intervaloDescanso;
        }
        
// metodo donde se establece que los intervalos son 25 y 5 minutos
        public Pomodoro() {
            this(25, 5);
        }
        
// metodo que devuelve el valor del intervalo de trabajo 
        public int getIntervaloTrabajo() {
            return intervaloTrabajo;
        }

// metodo que permite modificar el valor del intervalo de trabajo    
        public void setIntervaloTrabajo(int intervaloTrabajo) {
            this.intervaloTrabajo = intervaloTrabajo; // permite asignar el nuevo valor
        }

// metodo que devuelve el valor del intervalo de descanso 
        public int getIntervaloDescanso() {
            return intervaloDescanso;
        }

// metodo que permite modificar el valor del intervalo de descanso
        public void setIntervaloDescanso(int intervaloDescanso) {
            this.intervaloDescanso = intervaloDescanso; // permite asignar el nuevo valor
        }
}

