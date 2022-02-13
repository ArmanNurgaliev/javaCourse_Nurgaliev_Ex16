public class Road {

    private int person;
    private int cars;

    public Road() {
    }

    public Road(int person, int cars) {
        this.person = person;
        this.cars = cars;
    }

    public synchronized void personWait() {
        try {
            while (person < 4)
                wait();
            person++;
            System.out.println("Светофор для пешеходов включен");
            notify();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void carsWait() {
        try {
            while (cars < 5)
                wait();
            cars++;
            System.out.println("Светофор для машин включен");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getCars() {
        return cars;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }
}