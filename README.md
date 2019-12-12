# Parking Lot

<hr>
Parking lot

This is a  parking lot system that can hold up to 'n' cars at any given point in time. Each slot is given a number starting at 1 increasing with increasing distance from the entry point in steps of one.

This system achieved an automated ticketing system that allows my customers to use my parking lot without human intervention.

When a car enters  parking lot,  a ticket issued to the driver. The ticket issuing process includes us documenting the registration number (number plate) and the colour of the car and allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are nice enough to always park in the slots allocated to them). The customer should be allocated a parking slot which is nearest to the entry. At the exit the customer returns the ticket which then marks the slot they were using as being available.

<hr>
<h1>Instructions to operate the system</h1>
<h2>Commands</h2>
<ul>
<li>create_parking_lot : -  create_parking_lot 'number'</li>
<li>park  :- park 'registration number' 'colour'</li>
<li>leave :- leave 'slot number'</li>
<li>status</li>
<li>registration_numbers_for_cars_with_colour :- registration_numbers_for_cars_with_colour 'colour' </li>
<li>slot_numbers_for_cars_with_colour :- slot_numbers_for_cars_with_colour 'colour' </li>
<li>slot_number_for_registration_number :- slot_number_for_registration_number 'registration number' </li>
<li>exit</li>
</ul>

<hr>
<h2>Build the application </h2>

Please use <b>mvn clean install </b> to build the system

<hr>
<h2>Run the application </h2>

Please use <b>java -jar parking_lot-1.0-SNAPSHOT.jar </b> to Run the system

1) It provide us with an interactive command prompt based shell where commands can be typed in<br>
2) It accept a filename as a parameter at the command prompt and read the commands from that file. You can refer "src/main/resources/parking_lot_file_inputs.txt" for more details
