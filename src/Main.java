import java.util.ArrayList;

 class Lab_11_Listmaker {

    private static ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            String choice = SafeInput.getRegExString("Enter your choice: ", "[AaDdPpQq]").toString();
            switch (Character.toUpperCase(choice.charAt(0))) {
                case 'A':
                    addItemToList();
                    break;
                case 'D':
                    deleteItemFromList();
                    break;
                case 'P':
                    printList();
                    break;
                case 'Q':
                    running = confirmQuit();
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
        System.out.println();
        System.out.println("Current List:");
        printNumberedList();
        System.out.println();
    }

    private static void addItemToList() {
        String newItem = SafeInput.getString("Enter the item to add: ");
        myArrList.add(newItem);
        System.out.println("Item added to the list.");
    }

    private static void deleteItemFromList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        printNumberedList();
        int itemToDelete = SafeInput.getRangedInt("Enter the number of the item to delete: ", 1, myArrList.size());
        myArrList.remove(itemToDelete - 1);
        System.out.println("Item deleted from the list.");
    }

    private static void printList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("List:");
        for (String item : myArrList) {
            System.out.println(item);
        }
    }

    private static void printNumberedList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("List:");
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ". " + myArrList.get(i));
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N): ");
    }
}
