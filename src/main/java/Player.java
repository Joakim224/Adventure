public class Player {
        private Room currentRoom;

        public Room getCurrentRoom() {
            return currentRoom;
        }

        public void setCurrentRoom(Room currentRoom) {
            this.currentRoom = currentRoom;
        }

        public boolean goSouth () {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                return true;
            } else {
                System.out.println("The path is blocked!");
                return false;
            }
        }

        public boolean goNorth () {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                return true;
            } else {
                System.out.println("The path is blocked!");
                return false;
            }
        }

        public boolean goWest () {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                return true;
            } else {
                System.out.println("The path is blocked!");
                return false;
            }
        }

        public boolean goEast () {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                return true;
            } else {
                System.out.println("The path is blocked!");
                return false;
            }
        }
    }



