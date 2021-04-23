package knox.drawshapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class EquilateralTriangle extends AbstractShape{
	
	private int side;
	
	public EquilateralTriangle(Color color, Point center, int side){
		super(center, color);
		boundingBox = new BoundingBox((int)(center.x-side/2), (int)(center.x+side/2), (int)(center.y-side*(Math.sqrt(3))/4), (int)(center.y+side*(Math.sqrt(3))/4));
        this.side=side;
	}

	@Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        int x[]= {(int)getAnchorPoint().getX(), (int)(getAnchorPoint().getX()-(side/2)), (int)(getAnchorPoint().getX()+(side/2))};
        int y[]= {(int)(getAnchorPoint().getY()-side*(Math.sqrt(3))/4), (int)(getAnchorPoint().getY()+side*(Math.sqrt(3))/4), (int)(getAnchorPoint().getY()+side*(Math.sqrt(3))/4)};
        int npoints=x.length;
        g.fillPolygon(x, y, npoints);
    }

 
    
    public String toString() {
        return String.format("EQUILATERALTRIANGLE %d %d %d %s %s", 
                this.getAnchorPoint().x, 
                this.getAnchorPoint().y,
                this.side,
                Util.colorToString(this.getColor()),
                this.isSelected());
    }

	@Override
	public void scale(double factor) {
		this.side = (int)(factor * this.side);
	}

}
