public class MazeAgentTest {
    public static void main(String[] args) {
        // Labirinto: 0 = caminho, 1 = parede
        int[][] maze = {
            { 0, 1, 0, 0, 0 },
            { 0, 1, 1, 1, 0 },
            { 0, 0, 0, 1, 0 },
            { 0, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 0 }
        };

        Position start = new Position(0, 0);  // Posição inicial
        Position goal = new Position(4, 4);   // Posição do objetivo

        MazeAgent agent = new MazeAgent(maze, start, goal);
        agent.searchGoal();
    }
}