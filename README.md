# Conveyor Bag sorter
## About Project
This COMPSYS725 Assignment two aims to implement the conveyor control system for a small part of the rudimentary baggage handling system (BHS). The main objectve of this assignment is to prevent the collision of bags using appropriate mutual exclusion algorithms which includes central server, ring token and multicasting.

## Critical Section
There are three critical sections in this assignment and each critical section implements a different mutual exclusion section. 
-  Critical Section 1 is where baggages are going from conveyors 2 and 6 and into conveyor 7. The algorithm implemented in this critical section to ensure mutual exclusion is Central Server. 
-  Critical Section 2 is where baggages are going from conveyors 4 and 7 and into conveyor 8. The algorithm implemented in this critical section to ensure mutual exclusion is Ring Token. 
-  Critical Section 3 is where baggages are going from conveyors 8 and 11 and into conveyor 9. The algorithm implemented in this critical section to ensure mutual exclusion is Multicast. 

## How To Run
- Unzip the folder
- Navigate into the fbdk directory using the terminal
- To run, you enter "java -jar editor.jar" into the terminal
- An User Agreement prompt will be displayed on the screen where you will need to accept the terms to continue.
- Click the File/Open icon located top left corner of the main window, selected the BaggageSystemCTL file from the src/cs725 folder.
- Once the file is opened, click the green play button to run. 
- A HMI window where you can select the bag inputs and a VIEW window which provides a visual view of the conveyors will appear. To input bags onto the conveyor, simple press the Bag Input buttons. 
