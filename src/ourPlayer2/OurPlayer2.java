/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourPlayer2;

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
public class OurPlayer2 implements battleship.interfaces.BattleshipsPlayer
{

    private final static Random rnd = new Random();
    private int sizeX;
    private int sizeY;
    private int nextX;
    private int nextY;
    private int corX = 0;
    private int corY = -2;
    private int th = 0;
    private int ing = 0;
    int count = 0;
    ArrayList<Position> coordinates = new ArrayList<>();
    private boolean hit = false;
    private int enemyFleet;
    private int enemyFleet2;
    ArrayList<Position> killShot1 = new ArrayList<>();

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
        Position hitShot = null;
        if (hit == true)
        {
            killWounded(corX, corY);
            for (Position i : killShot1)
            {
                if (enemyFleet == enemyFleet2)
                {
                    for (int j = 0; j < killShot1.size(); ++j)
                    {
                        hitShot = killShot1.get(j);
                    }
                    hit = false;
                    System.out.println("skud" + hitShot.toString());
                    return hitShot;
                }
//                hit = false;
//                System.out.println("skud" + hitShot.toString());
//                return hitShot;
            }
        } else
        {
            if (corY >= (sizeY - 1))
            {
                if (count == 1)
                {
                    corY = 0;
                    count = 0;
                    if (corX >= sizeX)
                    {
                        corX = 0;
                    }
                    corX++;
                    Position shot = new Position(corX, corY);
                    System.out.println("else skud" + shot.toString());
                    return shot;
                }
                if (count == 0)
                {
                    count++;
                    corY = 1;
                    if (corX >= sizeX)
                    {
                        corX = 0;
                    }
                    corX++;
                    Position shot = new Position(corX, corY);
                    System.out.println("else skud" + shot.toString());
                    return shot;
                }
            }
            corY = corY + 2;
            Position shot = new Position(corX, corY);
            System.out.println("else skud" + shot.toString());
            return shot;
        }
        return null;
    }

    public ArrayList<Position> getCoordinates()
    {
        System.out.println(coordinates.toString());
        return coordinates;
    }

    public ArrayList<Position> killWounded(int corX, int corY)
    {
        killShot1.clear();
        int tempX = corX;
        int tempY = corY;
        killShot1.add(new Position(tempX - 1, tempY));
        killShot1.add(new Position(tempX + 1, tempY));
        killShot1.add(new Position(tempX, tempY - 1));
        killShot1.add(new Position(tempX, tempY + 1));

        return killShot1;

    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips)
    {

        if (hit && !this.hit)
        {
            enemyFleet = enemyShips.getNumberOfShips();
            enemyFleet2 = enemyFleet;
            this.hit = hit;
        }
        if (hit && this.hit)
        {
            enemyFleet2 = enemyShips.getNumberOfShips();
        }
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
}
