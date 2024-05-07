package Movie;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 * @RozaanHP
 * **/
public class tabeldataMovie extends AbstractTableModel{
    List<dataMovie>dp;
    public tabeldataMovie(List<dataMovie>dp){
        this.dp = dp;
    }
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Penokohan";
            case 3:
                return "Akting";
            case 4:
                return "Nilai";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return dp.get(row).getJudul();
            case 1:
                return dp.get(row).getAlur();
            case 2:
                return dp.get(row).getPenokohan();
            case 3:
                return dp.get(row).getAkting();
            case 4:
                return dp.get(row).getMilai();
            default:
                return null;
        }
    }
}
