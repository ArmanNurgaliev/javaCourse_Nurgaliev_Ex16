public class Main {
    public static void main(String[] args) throws InterruptedException {
        Road road = new Road(0, 0);
        PersonThread personThread = new PersonThread(road);
        CarsThread carsThread = new CarsThread(road);
        personThread.start();
        carsThread.start();


    }
}


class PersonThread extends Thread {
    private Road road;

    public PersonThread(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        try {
            while (road.getPerson() < 4) {
                road.setPerson(road.getPerson() + 1);
                System.out.println(road.getPerson() + " людей ждут у светофора");
                Thread.sleep(2000);
            }
                road.personWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CarsThread extends Thread {
    private Road road;

    public CarsThread(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        try {
            while (road.getCars() < 5) {
                road.setCars(road.getCars() + 1);
                System.out.println(road.getCars() + " машин ждут у светофора");
                Thread.sleep(5000);
            }
                road.carsWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}