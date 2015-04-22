package application;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue {
	 public static void main(String args[]) {
       
		 PriorityQueue<Patient> patient = new PriorityQueue<Patient>(5, new SortQueueViaPriority());
        patient.add(new Patient("Clare", 5));
        patient.add(new Patient("Catherine", 7));
        patient.add(new Patient("Johnny", 9));
        patient.add(new Patient("Paul", 2));
        patient.add(new Patient("Hannah", 4));
        patient.add(new Patient("Matthew", 6));
        patient.add(new Patient("Fintan", 8));
        patient.add(new Patient("Miroslav", 10));
        patient.add(new Patient("Mllie", 11));
        patient.add(new Patient("Aidan", 1));
        

        while (!patient.isEmpty())
            System.out.println(patient.remove());
    }
}

class SortQueueViaPriority implements Comparator<Patient> {
    @Override
    public int compare(Patient f1, Patient f2) {
        return Integer.compare(f1.getPriority(), f2.getPriority());
    }
}

class Patient {
    private final String name;
    private final int priority;

    Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}