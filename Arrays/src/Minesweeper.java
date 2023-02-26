public class Minesweeper{
        public static void main(String args[]){
                int n = Integer.parseInt(args[0]);
                int m = Integer.parseInt(args[1]);
                int k = Integer.parseInt(args[2]);
                int total = n * m;
                if(total < k){k = total;}
                boolean[] hasmine = new boolean[total];
                int[] cellval = new int[total];   
                int randnum;
                int count = 0;
                while(count != k){
                        randnum = (int)(Math.random()*(total));
                        if(!hasmine[randnum]){
                                hasmine[randnum]=true;
                                count++;
                        }
                }
                int position;
                int[] posneighbors = new int[8];
                int up;
                int down;
                int left;
                int right;
                int borderUp;
                int borderRight;
                int borderDown;
                int borderLeft;
                int borderCase;
                for(int j = 0; j < n; j++){
                        for(int i = 0; i < m; i++){
                                up = j - 1;
                                down = j + 1;
                                left = i - 1;
                                right = i + 1;
                                
                                borderUp = (up < 0)? 1 : 0;
                                borderRight = (right >= m)? 1 : 0;
                                borderDown = (down >= n)? 1 : 0;
                                borderLeft = (left < 0)? 1 : 0;
                                borderCase = 8 * borderRight + 4 * borderDown + 2 * borderLeft + borderUp;
                                
                                position = i + j*m;
                                posneighbors[0] = i + (j - 1)*m;
                                posneighbors[1] = i + (j + 1)*m;
                                posneighbors[2] = i - 1 + j*m;
                                posneighbors[3] = i + 1 + j*m;
                                posneighbors[4] = i + 1 + (j - 1)*m;
                                posneighbors[5] = i - 1 + (j - 1)*m;
                                posneighbors[6] = i - 1 + (j + 1)*m;
                                posneighbors[7] = i + 1 + (j + 1)*m;
                                if(hasmine[position])
                                                        System.out.print("*  "); 
                                else{
                                        switch (borderCase){
                                                case 1:for(int l = 0; l < 8 ; l++){
                                                                if(l == 0 || l == 4 || l == 5)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 2:for(int l = 0; l < 8 ; l++){
                                                                if(l == 2 || l == 5 || l == 6)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 3:for(int l = 0; l < 8 ; l++){
                                                                if(l == 0 || l == 2 || l == 4|| l == 5 || l == 6)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 4:for(int l = 0; l < 8 ; l++){
                                                                if(l == 1 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 5:for(int l = 0; l < 8 ; l++){
                                                                if(l == 0 || l == 1 || l == 4 || l == 5 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 6:for(int l = 0; l < 8 ; l++){
                                                                if(l == 1 || l == 2 || l == 5 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 7:for(int l = 0; l < 8 ; l++){
                                                                if(l == 0 || l == 1 || l == 2 || l == 4 || l == 5 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 8:for(int l = 0; l < 8 ; l++){
                                                                if(l == 3 || l == 4 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 9:for(int l = 0; l < 8 ; l++){
                                                                if(l == 0 || l == 3 || l == 4 || l == 5 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 10:for(int l = 0; l < 8 ; l++){
                                                                if(l == 2 || l == 3 || l == 4 ||l == 5 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 11:for(int l = 0; l < 8 ; l++){
                                                                if(l == 0 || l == 2 || l == 3|| l == 4 || l == 5 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 12:for(int l = 0; l < 8 ; l++){
                                                                if(l == 1 || l == 3 || l == 4 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 13:for(int l = 0; l < 8 ; l++){
                                                                if(l == 0 || l == 1 || l == 3 || l == 4 || l == 5 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 14:for(int l = 0; l < 8 ; l++){
                                                                if(l == 1 || l == 2 || l == 3 || l == 4 || l == 5 || l == 6 || l == 7)
                                                                        continue;
                                                                else if(hasmine[posneighbors[l]])
                                                                        cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                break;

                                                case 15:System.out.print(cellval[position] + "  ");
                                                break;    

                                                default:for(int l = 0; l < 8 ; l++){
                                                                if(hasmine[posneighbors[l]])
                                                                cellval[position]++;
                                                        }
                                                        System.out.print(cellval[position] + "  ");
                                                }
                                        }
                                }
                        System.out.println();
                }
        }
}       
