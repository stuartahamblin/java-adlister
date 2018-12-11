import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "guessGame")
public class guessGame extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//          TODO
    }
}

//DRILL 3 (Guessing Game)
//        A user goes to a url "/guess" and is prompted to guess a number between 1 and 100. The user will be taken to another page and if the answer is correct, a message will be displayed indicating the win; otherwise a higher or lower message will be given with a link to the form to guess again.
//        - use a POST request on the form
//        - use one servlet and two jsps
//        - use an instance field on a servlet
//        - require the form input to only be numbers between 1 and 100
//        - contain your logic in the servlet for generating the random number and checking if the user guess is correct
//        Bonus: create a link that will reset the random computer number to a new number
