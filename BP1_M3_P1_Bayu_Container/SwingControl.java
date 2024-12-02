public class SwingControl {

    private double angle; // Sudut awal
    private double kp = 0.1; // Konstanta proporsional
    private double ki = 0.01; // Konstanta integral
    private double kd = 0.05; // Konstanta derivatif
    private double integral = 0;
    private double previousError = 0;

    public void SwingControl() {
        this.angle = 0; // Sudut awal 0 derajat
    }

    // Metode untuk menghitung sinyal kontrol PID
    private double calculateControlSignal(double targetAngle) {
        double error = targetAngle - angle;
        integral += error;
        double derivative = error - previousError;
        
        // Rumus PID untuk sinyal kontrol
        double controlSignal = (kp * error) + (ki * integral) + (kd * derivative);
        
        previousError = error;
        return controlSignal;
    }

    // Metode untuk menggerakkan sudut menuju target
    public void moveToTargetAngle(double targetAngle) {
        while (Math.abs(targetAngle - angle) > 0.01) {
            // Hitung sinyal kontrol dari PID
            double controlSignal = calculateControlSignal(targetAngle);
            
            // Tambahkan sinyal kontrol ke sudut saat ini
            angle += controlSignal;
            
            // Cetak status sudut
            System.out.printf("Current Angle: %.2f degrees%n", angle);
            
            // Simulasi jeda waktu (100 ms) agar tampilan berubah bertahap
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reached target angle: " + targetAngle);
    }

    public static void main(String[] args) {
        SwingControl swingControl = new SwingControl();
        
        double targetAngle = 30.0; // Sudut target yang ingin dicapai
        System.out.println("Moving towards target angle: " + targetAngle + " degrees");
        
        swingControl.moveToTargetAngle(targetAngle);
    }
}
