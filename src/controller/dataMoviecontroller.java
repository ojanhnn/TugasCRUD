package controller;
import java.util.List;
import javax.swing.JOptionPane;
import DAOdataMovie.DAOdataMovie;
import DAOImplements.DAOMovie;
import Movie.*;
import view.*;
/**
 * @RozaanHP
 * **/
public class dataMoviecontroller {
    MainView frame;
    DAOMovie impldataMovie;
    List<dataMovie> dp;
    public dataMoviecontroller(MainView frame){
        this.frame = frame;
        impldataMovie = new DAOdataMovie();
        dp = impldataMovie.getALL();
    }
    public void isitable(){
        dp = impldataMovie.getALL();
        tabeldataMovie mp = new tabeldataMovie(dp);
        frame.getMovieTable().setModel(mp);
    }
    public void create(){
        dataMovie dp = new dataMovie();
        dp.setJudul(frame.getJudul());
        dp.setAlur(Double.parseDouble(frame.getAlur()));
        dp.setPenokohan(Double.parseDouble(frame.getPenokohan()));
        dp.setAkting(Double.parseDouble(frame.getAkting()));
        impldataMovie.create(dp);
    }
    public void update(){
        dataMovie dp = new dataMovie();
        dp.setJudul(frame.getJudul());
        dp.setAlur(Double.parseDouble(frame.getAlur()));
        dp.setPenokohan(Double.parseDouble(frame.getPenokohan()));
        dp.setAkting(Double.parseDouble(frame.getAkting()));
        impldataMovie.update(dp);
    }
    public void delete() {
        dataMovie dp = new dataMovie();
        dp.setJudul(frame.getJudul());
        impldataMovie.delete(dp);
    }
}
