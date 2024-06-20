import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        String playerO="O";
        String currenPlayer = playerX;
        boolean gameOver = false;
        int turn=0;
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
                    board[r][c]=tile;
                    boardPanel.add(tile);
                    tile.setBackground(Color.darkGray);
                    tile.setForeground(Color.white);
                    tile.setFont(new Font("Arial",Font.BOLD,100));
                    tile.setFocusable(false);
                    //tile.setText(currenPlayer);
                    tile.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (gameOver) return;
                            JButton tile  =(JButton) e.getSource();
                            if (tile.getText()=="")
                            {
                                tile.setText(currenPlayer);
                                turn++;
                                checkWinner();

                                if (gameOver==true) return;
                                if (!gameOver)
                                {
                                    if (currenPlayer==playerX)
                                    {
                                        currenPlayer=playerO;
                                    }
                                    else {
                                        currenPlayer = playerX;
                                    }
                                    txtLabel.setText(currenPlayer+"'s turn.");
                                }



                            }

                        }
                    });


                }
            }
        }

    void checkWinner(){
        //check horizonal
        for (int r=0;r<3;r++)
        {
            if (board[r][0].getText()=="") continue;
            if (board[r][0].getText().equals(board[r][1].getText()) &&
                    board[r][1].getText().equals(board[r][2].getText()) )
            {
                for (int c=0;c<3;c++)
                {
                    setWinner(board[r][c]);

                }
                gameOver=true;
                return;
            }
        }
        //check vertical
        for (int c=0;c<3;c++)
        {
            if (board[0][c].getText()=="") continue;
            if (board[0][c].getText().equals(board[1][c].getText()) && board[1][c].getText().equals(board[2][c].getText()) )
            {
                for (int r=0;r<3;r++)
                {
                    setWinner(board[r][c]);
                }
                gameOver=true;
                return;
            }
        }
        //check duong cheo
        if (board[0][0].getText() == board[1][1].getText() &&
                board[1][1].getText() == board[2][2].getText() &&
                board[0][0].getText()!="") {
            setWinner(board[0][0]);
            setWinner(board[1][1]);
            setWinner(board[2][2]);
            gameOver=true;
            return;

        }
        //check nguoc duong cheo
        if (board[2][0].getText() == board[1][1].getText() &&
                board[1][1].getText() == board[0][2].getText() &&
                board[2][0].getText()!="") {
            setWinner(board[2][0]);
            setWinner(board[1][1]);
            setWinner(board[0][2]);
            gameOver=true;
            return;

        }
        if (turn==9)
        {
            gameOver=true;
            for (int i=0;i<3;i++)
            {
                for (int j=0;j<3;j++)
                {
                    setTie(board[i][j]);
                }

            }
        }
    }
    void setTie(JButton tile){
            tile.setForeground(Color.ORANGE);
            tile.setBackground(Color.darkGray);
            txtLabel.setText("FULL!");
    }
    void setWinner(JButton tile)
    {
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.gray);
        txtLabel.setText(currenPlayer+" is the winner !");
    }
}
