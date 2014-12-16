/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourPlayer;

import battleship.interfaces.Board;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Ship;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jeanette
 */
public class OurPlayer implements battleship.interfaces.BattleshipsPlayer
{

    private final static Random rnd = new Random();
    private int sizeX;
    private int sizeY;
    private int nextX;
    private int nextY;
    private int corX = 0;
    private int corY = 0;
    ArrayList<Position> coordinates = new ArrayList<>();
    private boolean hit = false;
    private Position shoot;

    @Override
    public void startMatch(int rounds)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startRound(int round)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void placeShips(Fleet fleet, Board board)
    {
        nextX = 0;
        nextY = 0;
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        for (int i = 0; i < fleet.getNumberOfShips(); ++i)
        {
            Ship s = fleet.getShip(i);
            boolean vertical = rnd.nextBoolean();
            Position pos;
            if (vertical)
            {
                int x = rnd.nextInt(sizeX);
                int y = rnd.nextInt(sizeY - (s.size() - 1));
                pos = new Position(x, y);
            } else
            {
                int x = rnd.nextInt(sizeX - (s.size() - 1));
                int y = rnd.nextInt(sizeY);
                pos = new Position(x, y);
            }
            board.placeShip(pos, s, vertical);
        }
    }

    @Override
    public void incoming(Position pos)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    int i = 0;

    @Override
    public Position getFireCoordinates(Fleet enemyShips)
    {
        returnCoordinates();
        if (hit == true)
        {
           // killWounded();
        } else
        {

            for (i = 0; i < coordinates.size(); ++i)
            {
                shoot = coordinates.get(i);
            }

        }
        return shoot;
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips)
    {
        this.hit = hit;

    }

    @Override
    public void endRound(int round, int points, int enemyPoints)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endMatch(int won, int lost, int draw)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Position> returnCoordinates()
    {
        coordinates.add(new Position(0, 0));
        coordinates.add(new Position(2, 0));
        coordinates.add(new Position(4, 0));
        coordinates.add(new Position(6, 0));
        coordinates.add(new Position(8, 0));
        coordinates.add(new Position(1, 1));
        coordinates.add(new Position(3, 1));
        coordinates.add(new Position(5, 1));
        coordinates.add(new Position(7, 1));
        coordinates.add(new Position(9, 1));
        coordinates.add(new Position(0, 2));
        coordinates.add(new Position(2, 2));
        coordinates.add(new Position(4, 2));
        coordinates.add(new Position(6, 2));
        coordinates.add(new Position(8, 2));
        coordinates.add(new Position(1, 3));
        coordinates.add(new Position(3, 3));
        coordinates.add(new Position(5, 3));
        coordinates.add(new Position(7, 3));
        coordinates.add(new Position(9, 3));
        coordinates.add(new Position(0, 4));
        coordinates.add(new Position(2, 4));
        coordinates.add(new Position(4, 4));
        coordinates.add(new Position(6, 4));
        coordinates.add(new Position(8, 4));
        coordinates.add(new Position(1, 5));
        coordinates.add(new Position(3, 5));
        coordinates.add(new Position(5, 5));
        coordinates.add(new Position(7, 5));
        coordinates.add(new Position(9, 5));
        coordinates.add(new Position(0, 6));
        coordinates.add(new Position(2, 0));
        coordinates.add(new Position(2, 6));
        coordinates.add(new Position(4, 6));
        coordinates.add(new Position(6, 6));
        coordinates.add(new Position(8, 6));
        coordinates.add(new Position(1, 7));
        coordinates.add(new Position(3, 7));
        coordinates.add(new Position(5, 7));
        coordinates.add(new Position(7, 7));
        coordinates.add(new Position(9, 7));
        coordinates.add(new Position(0, 8));
        coordinates.add(new Position(2, 8));
        coordinates.add(new Position(4, 8));
        coordinates.add(new Position(6, 8));
        coordinates.add(new Position(8, 8));
        coordinates.add(new Position(1, 9));
        coordinates.add(new Position(3, 9));
        coordinates.add(new Position(5, 9));
        coordinates.add(new Position(7, 9));
        coordinates.add(new Position(9, 9));
        return coordinates;
    }
}
