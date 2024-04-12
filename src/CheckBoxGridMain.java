import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class CheckBoxGridMain extends JPanel {
   public static final int GRID_PANEL_ROWS = 1;
   public static final int GRID_PANEL_COLS = 1;
   private static final int GAP = 1;
   private CheckBoxGrid[][] checkBoxGrid = new CheckBoxGrid[GRID_PANEL_ROWS][GRID_PANEL_COLS];

   public CheckBoxGridMain() {
      setLayout(new GridLayout(GRID_PANEL_ROWS, GRID_PANEL_COLS, GAP, GAP));
      for (int row = 0; row < checkBoxGrid.length; row++) {
         for (int col = 0; col < checkBoxGrid[row].length; col++) {
            checkBoxGrid[row][col] = new CheckBoxGrid(row, col);
            add(checkBoxGrid[row][col]);
         }
      }
   }

   private static void createAndShowGui() {
      CheckBoxGridMain mainPanel = new CheckBoxGridMain();

      JFrame frame = new JFrame("CheckBox Grid");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
      
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

@SuppressWarnings("serial")
class CheckBoxGrid extends JPanel {
   private static final int CHECK_BOX_ROWS = 5;
   private static final int CHECK_BOX_COLS = 5;
   private static final int GAP = -5;
   private JCheckBox[][] checkBoxes = new JCheckBox[CHECK_BOX_ROWS][CHECK_BOX_COLS];
   private int gridIndex;
   private ItemListener itemListener = new MyCheckBoxListener();
   private int row;
   private int col;

   public CheckBoxGrid(int row, int col) {
      this.row = row;
      this.col = col;
      gridIndex = row + col + 1;
      setBorder(BorderFactory.createTitledBorder(String.valueOf(gridIndex)));
      setLayout(new GridLayout(CHECK_BOX_ROWS, CHECK_BOX_COLS, GAP, GAP));

      for (int cbRow = 0; cbRow < checkBoxes.length; cbRow++) {
         for (int cbCol = 0; cbCol < checkBoxes[cbRow].length; cbCol++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.addItemListener(itemListener);
            add(checkBox);
            checkBoxes[cbRow][cbCol] = checkBox;
         }
      }
   }

   private class MyCheckBoxListener implements ItemListener {

      @Override
      public void itemStateChanged(ItemEvent itemEvt) {
         JCheckBox source = (JCheckBox) itemEvt.getSource();
         boolean selected = source.isSelected();
         int cbRow = -1;
         int cbCol = -1;
         for (int r = 0; r < checkBoxes.length; r++) {
            for (int c = 0; c < checkBoxes[r].length; c++) {
               if (source.equals(checkBoxes[r][c])) {
                  cbRow = r;
                  cbCol = c;
               }
            }
         }

         String text = String.format("Grid %d, selected: %b, at [%d, %d]", 
               (row + col + 1), selected, (cbCol+1), (cbRow+1)); // corrected row/col order
         System.out.println(text);
      }

   }

}