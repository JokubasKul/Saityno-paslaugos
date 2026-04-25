package lt.viko.eif.jkulbokas;

<<<<<<< HEAD
import lt.viko.client.LibraryService;
import lt.viko.client.LibraryServiceImplService;
import lt.viko.client.Shelf;

import lt.viko.eif.jkulbokas.Services.TransformService;

import java.util.List;

public class Wsimport_test {
    public static void main(String[] args) throws Exception {
=======
import lt.viko.client.Book;
import lt.viko.client.LibraryServiceImplService;
import lt.viko.client.LibraryService;
import lt.viko.client.Shelf;

import java.util.List;

public class Wsimport_test {
    public static void main(String[] args) {
>>>>>>> b621a37c92eaac2aa75bd37626c592dce0eaa663

        LibraryServiceImplService libraryService = new LibraryServiceImplService();
        LibraryService port = libraryService.getLibraryServiceImplPort();

<<<<<<< HEAD
        List<lt.viko.client.Shelf> shelves = port.getAllShelves();

        LibraryWrapper libraryWrapper = new LibraryWrapper();
        libraryWrapper.setShelves(shelves);

        TransformService transformService=new TransformService();

        transformService.transformToXml(libraryWrapper);
        transformService.transformToPDF();
        transformService.transformToHTML();
    }
=======
        List<Shelf> shelves = port.getAllShelves();

        for (Shelf s : shelves) {
            System.out.println("Category: " + s.getCategory());

            if (s.getBooks() != null && s.getBooks().getBook() != null) {
                for (Book b : s.getBooks().getBook()) {
                    System.out.println("  Book: " + b.getTitle());
                }
            }
        }
    }

>>>>>>> b621a37c92eaac2aa75bd37626c592dce0eaa663
}
