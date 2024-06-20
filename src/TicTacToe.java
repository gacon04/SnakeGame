import java.awt.*;
import javax.swing.*;
public class TicTacToe {
        int boardWidth = 600;
        int boardHight = 650;
        JFrame frame = new JFrame("Tic-Tac-Toe");
        JLabel txtLabel = new JLabel();
        JPanel txtPanel = new JPanel();
        JPanel boardPanel = new JPanel();

        JButton[][] board = new JButton[3][3];
        String playerX="X";
        String playerO="0";
        String currenPlayer = playerX;
        public TicTacToe() {
            frame.setVisible(true); // Hiển thị JFrame
            frame.setSize(boardWidth, boardHight); // Thiết lập kích thước
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thiết lập hành động khi đóng cửa sổ
            frame.setLayout(new BorderLayout());

            txtLabel.setBackground(Color.darkGray);
            txtLabel.setForeground(Color.white);
            txtLabel.setFont(new Font("Montserrat Bold",Font.BOLD,50));
            txtLabel.setHorizontalAlignment(JLabel.CENTER);
            txtLabel.setText("Tic-Tac-Toe");
            txtLabel.setOpaque(true);

            txtPanel.setLayout(new BorderLayout());
            txtPanel.add(txtLabel);
            frame.add(txtPanel, BorderLayout.NORTH);

            boardPanel.setLayout(new GridLayout(3,3));
            boardPanel.setBackground(Color.gray);
            frame.add(boardPanel);
            for (int r=0;r<3;r++)
            {
                for (int c=0 ;c<3;c++)
                {
                    JButton tile = new JButton();
                    tile.setBackground(Color.darkGray);
                    tile.setForeground(Color.white);
                    tile.setFont(new Font("Arial",Font.BOLD,100));
                    tile.setFocusable(false);
                    board[r][c]=tile;
                    boardPanel.add(tile);

                }
            }
        }

}
