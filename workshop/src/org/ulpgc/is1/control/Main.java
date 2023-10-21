package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        RepairManager repairManager = new RepairManager();

        // i. Init. Crear el perfil de dos mecánicos.
        Mechanic mechanic1 = new Mechanic("Pablo", "León");
        Mechanic mechanic2 = new Mechanic("María", "Navarro");
        repairManager.addMechanic(mechanic1);
        repairManager.addMechanic(mechanic2);

        // ii. Init. Crear el perfil de dos vehículos con sus respectivos clientes.
        Customer customer1 = new Customer("Paula", new Phone("1234")); //caso de número no válido
        Customer customer2 = new Customer("Lola", new Phone("987654321"));


        Vehicle vehicle1 = new Vehicle("Toyota", "Camry", new Plate("1234ABC"), customer1);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", new Plate("7891ZYX"), customer2);


        repairManager.addVehicle(vehicle1);
        repairManager.addVehicle(vehicle2);


        // iii. Init. Crear dos piezas en el stock del taller.
        SparePart part1 = new SparePart("Filtro aceite", 20);
        SparePart part2 = new SparePart("Batería", 30);

        //iv. Imprimir por pantalla todos los datos del primer mecánico.
        Mechanic firstMechanic = repairManager.getMechanic("Pablo");
        if (firstMechanic != null) {
            System.out.println("Primer mecánico: " + firstMechanic.getName() + " " + firstMechanic.getSurname() + "\n");
        }

        // v. Imprimir por pantalla todos los datos del segundo vehículo.
        Vehicle secondVehicle = repairManager.getVehicle("7891ZYX");
        if (secondVehicle != null) {
            System.out.println("Segundo vehículo:");
            System.out.println("Marca: " + secondVehicle.getMake());
            System.out.println("Modelo: " + secondVehicle.getModel());
            System.out.println("Matrícula: " + secondVehicle.getPlate().getNumber());
            System.out.println("Nombre del propietario: " + secondVehicle.getOwner().getName());
            System.out.println("Número de teléfono del propietario: " + secondVehicle.getOwner().getPhone().getNumber() + "\n");
        }

        // vi. Registrar una reparación que realiza el primer mecánico sobre el segundo vehículo.
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2023-10-17");
            Repair repair = new Repair(date, "Reparación de filtro de aceite y batería.", 3);
            repair.setBreakdownType(BreakdownTypes.mechanical);
            repair.addPart(part1, 1);
            repair.addPart(part2, 2);

            repairManager.repair(secondVehicle, repair);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // vii. Formalizar el pago de la reparación anterior.
        Payment payment = new Payment(new Date(), repairManager.getVehicle("7891ZYX").getRepairsList().get(0).price());
        repairManager.getVehicle("7891ZYX").getRepairsList().get(0).setPayment(payment);

        // viii. Borrar el primer vehículo
        repairManager.removeVehicle("1234ABC");

        // ix. Imprimir por pantalla el número de vehículos del taller.
        int vehicleCount = repairManager.countVehicles();
        System.out.println("El número de vehículos en el taller es: " + vehicleCount + "\n");

        // x. Imprimir por pantalla toda la información de la reparación: datos generales, piezas sustituidas y el pago.
        Repair repair1 = repairManager.getVehicle("7891ZYX").getRepairsList().get(0);
        System.out.println("Información de la reparación:");
        System.out.println("ID: " + repair1.getId());
        System.out.println("Fecha: " + repair1.getDate());
        System.out.println("Descripción: " + repair1.getDescription());
        System.out.println("Esfuerzo: " + repair1.getEffort());
        System.out.println("Tipo de avería: " + repair1.getBreakdownType());
        System.out.println("Coste total:" + repair1.price() + "€");
        System.out.println("Día de pago: " + repair1.getPayment().getDate());
        System.out.println("Cantidad del pago:" + repair1.getPayment().getAmount() + "€");
        System.out.println("Partes reemplazadas:");
        for (Item item : repair1.getItems()) {
            System.out.println(item.getSparePart().getName() + ": " + item.getQuantity());
        }
    }
}
