import java.util.Stack;

class MazeAgent {
    private int[][] maze;
    private Position goal;
    private Stack<Position> path;

    public MazeAgent(int[][] maze, Position start, Position goal) {
        this.maze = maze;
        this.goal = goal;
        this.path = new Stack<>();
        this.path.push(start); // Começa na posição inicial
    }

    // Verifica se a posição é válida no labirinto
    private boolean isValidMove(int row, int col) {
        return row >= 0 && col >= 0 && row < maze.length && col < maze[0].length && maze[row][col] == 0;
    }

    // Executa a ação do agente para alcançar o objetivo
    public boolean searchGoal() {
        while (!path.isEmpty()) {
            Position current = path.peek();

            // Verifica se o objetivo foi alcançado
            if (current.row == goal.row && current.col == goal.col) {
                System.out.println("Objetivo alcançado! Caminho: " + path);
                return true;
            }

            // Marca posição atual como visitada
            maze[current.row][current.col] = -1;

            // Explora movimentos possíveis
            if (isValidMove(current.row - 1, current.col)) { // Cima
                path.push(new Position(current.row - 1, current.col));
            } else if (isValidMove(current.row + 1, current.col)) { // Baixo
                path.push(new Position(current.row + 1, current.col));
            } else if (isValidMove(current.row, current.col - 1)) { // Esquerda
                path.push(new Position(current.row, current.col - 1));
            } else if (isValidMove(current.row, current.col + 1)) { // Direita
                path.push(new Position(current.row, current.col + 1));
            } else {
                // Se não há movimentos válidos, retrocede (backtracking)
                path.pop();
            }
        }

        System.out.println("Não foi possível alcançar o objetivo.");
        return false;
    }
}