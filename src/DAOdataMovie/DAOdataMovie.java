package DAOdataMovie;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import koneksi.connec;
import Movie.*;
import DAOImplements.DAOMovie;
/**
 * @RozaanHP
 * **/
public class DAOdataMovie implements DAOMovie{
    Connection connection;
    final String select = "SELECT * FROM movie";
    final String create = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE movie SET alur=?, penokohan=?, akting=?, nilai=? WHERE judul=?";
    final String delete = "DELETE FROM movie WHERE judul=?";
    public DAOdataMovie(){
        connection = connec.connection();
    }

    @Override
    public void create(dataMovie p) {
        PreparedStatement statement = null;
        try {
            // Calculate nilai
            double nilai = calculateNilai(p.getAlur(), p.getPenokohan(), p.getAkting());

            statement = connection.prepareStatement(create, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setDouble(2, p.getAlur());
            statement.setDouble(3, p.getPenokohan());
            statement.setDouble(4, p.getAkting());
            statement.setDouble(5, nilai); // Set nilai
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                p.setJudul(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void update(dataMovie p) {
        PreparedStatement statement = null;
        try {
            double nilai = calculateNilai(p.getAlur(), p.getPenokohan(), p.getAkting());
            statement = connection.prepareStatement(update);
            statement.setDouble(1, p.getAlur());
            statement.setDouble(2, p.getPenokohan());
            statement.setDouble(3, p.getAkting());
            statement.setDouble(4, nilai);
            statement.setString(5, p.getJudul());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(dataMovie p) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, p.getJudul());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private double calculateNilai(double alur, double penokohan, double akting) {
        return (alur + penokohan + akting) / 3;
    }
    @Override
    public List<dataMovie> getALL() {
        List<dataMovie> dp = null;
        try{
            dp = new ArrayList<dataMovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                dataMovie movie = new dataMovie();
                movie.setJudul(rs.getString("judul"));
                movie.setAlur(rs.getDouble("alur"));
                movie.setPenokohan(rs.getDouble("penokohan"));
                movie.setAkting(rs.getDouble("akting"));
                movie.setMilai(rs.getDouble("nilai"));
                dp.add(movie);
            }
        }catch (SQLException ex){
            Logger.getLogger(DAOdataMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
}
