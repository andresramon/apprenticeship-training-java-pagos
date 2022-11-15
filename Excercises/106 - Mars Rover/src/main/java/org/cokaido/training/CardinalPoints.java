package org.cokaido.training;


  public  enum CardinalPoints {
        N(0, 1), S(0, -1), E(1, 0), O(-1, 0);

        private final int xAxis;
        private final int yAxis;

        CardinalPoints(int xAxis, int yAxis) {
            this.xAxis = xAxis;
            this.yAxis = yAxis;
        }

        public int getXAxis() {
            return xAxis;
        }

        public int getYAxis() {
            return yAxis;
        }
    }

