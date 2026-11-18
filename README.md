# Car Dealership


A console app that allows the user to manage a their car dealership inventory.


## Description of the Project

This application allows the user to select an option from a menu screen. They may add vehicles
by providing all of the vehicle information. They can also remove vehicles by VIN number. Lastly, they are able to
search for vehicles using any of the vehicle's info as parameters.


## Features

<!-- One bullet per thing the app can do, in the order of your menu. Mark bonuses.
     For an API (Capstone 3), one line per endpoint instead: method, path, what it does.
     Be honest: list what works. If something is half done, say so under Future Work instead.
     Example:
     - Shows every product in the store
     - Searches products by name (bonus) -->

- Add new vehicles to an inventory (a csv file)
- Remove vehicles from the inventory
- Search for vehicles using one of its parameters


## Setup

### Prerequisites

- Java 17 (Amazon Corretto), the version used in class.
- IntelliJ IDEA Community Edition: <https://www.jetbrains.com/idea/download/>

### Running the application

1. Clone this repository, or download it as a zip and unzip it.
2. In IntelliJ: File > Open, pick the project folder (the one that holds `pom.xml`), press Open.
3. Wait for IntelliJ to finish indexing (progress bar at the bottom).
4. Open `src/main/java/com/pluralsight/Main.java`. <!-- replace YourMainClassName with the class that has main -->
5. Right-click inside the file and choose Run 'Main.main()'.

### Data and configuration

<!-- OPTIONAL. Anything the program needs that is not code: data files and where they must sit, files the
     program creates, a database script to run first, a settings file to edit (connection, port).
     If there is nothing, delete this subsection, heading included.
     Example:
     - `inventory.csv` sits at the project root, next to `pom.xml`. The program reads it at start.
     - `logs.txt` is created by the program at the project root on the first run. -->

- inventory.csv sits at the project root, next to 'pom.xml' and the program reads it at the start.

## Technologies Used

- Java 17
- IntelliJ IDEA
<!-- Add anything else you used: a library, Maven plugins, an external tool. For a console app this list is short. That is fine. -->

## Demo

<!-- Pictures of the app running: the console for a console app, Insomnia or Swagger for an API.
     Screenshots are enough; a GIF is a bonus.
     1. Create a folder named `images` at the project root, next to `pom.xml`.
     2. Take screenshots of the app in the IntelliJ console (the menu, one feature, one error message):
          Windows: Win + Shift + S, drag a rectangle, then paste into Paint and save as PNG, or open the
                   notification and save. Save into the `images` folder.
          Mac:     Shift + Cmd + 4, drag a rectangle. The file lands on the Desktop; move it into `images`.
     3. Name the files by what they show: `images/menu.png`, `images/search.png`.
     4. Reference each one below with a relative path. No spaces in file names.
     5. Commit the images with the rest of your work (Git > Commit shows them as unversioned files: tick them).
     Optional GIF: LICEcap (free, Windows and Mac, <https://www.cockos.com/licecap/>) records a region of the
     screen straight to a .gif. Keep it under 10 seconds and under 10 MB, save it into `images`. -->

![Screenshot 2026-11-18 at 8.27.05 AM.png](images/Screenshot%202026-11-18%20at%208.27.05%E2%80%AFAM.png)

![Screenshot 2026-11-18 at 8.27.38 AM.png](images/Screenshot%202026-11-18%20at%208.27.38%E2%80%AFAM.png)

## A piece of code I am proud of

<!-- Paste one short block of your own code (5 to 15 lines) between the three backticks, then write two
     or three sentences: what it does and why you chose to write it that way. This is what you show on
     demo day and what you talk about in an interview. -->

```java
public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if((vehicle.getPrice().compareTo(min) >= 0) && vehicle.getPrice().compareTo(max) <= 0){
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }
```

## Future Work

<!-- What you would add or fix next, one bullet each. Unfinished bonuses belong here. -->

- This could become something very useful for an actual dealership with some work

## Resources

<!-- What helped you: the workbook, the week's hub pages, a tutorial, a documentation page. Real links. -->

- Java YearUp Fall 2026 hub: <https://raymaroun.github.io/yearup-java-fall2026/>
- https://www.w3schools.com

## Author

<!-- Your name and, if you like, your GitHub profile link. For a team workshop, one line per person with what each one built. -->

- **Brendan West**

## Thanks

<!-- Optional. The people who helped: the instructor, a classmate who debugged with you, a mentor. -->
