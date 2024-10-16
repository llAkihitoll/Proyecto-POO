public class Pomodoro {
        private int intervaloTrabajo;
        private int intervaloDescanso;
    
        public Pomodoro(int intervaloTrabajo, int intervaloDescanso) {
            this.intervaloTrabajo = intervaloTrabajo;
            this.intervaloDescanso = intervaloDescanso;
        }
    
        public Pomodoro() {
            this(25, 5);
        }
    
        public int getIntervaloTrabajo() {
            return intervaloTrabajo;
        }
    
        public void setIntervaloTrabajo(int intervaloTrabajo) {
            this.intervaloTrabajo = intervaloTrabajo;
        }
    
        public int getIntervaloDescanso() {
            return intervaloDescanso;
        }
    
        public void setIntervaloDescanso(int intervaloDescanso) {
            this.intervaloDescanso = intervaloDescanso;
        }
}

