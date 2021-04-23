package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class RegularHexagon extends AbstractShape{
private int radius;
	
	public RegularHexagon(Color color, Point center, int radius){
		super(center, color);
		boundingBox = new BoundingBox(center.x - radius, center.x + radius, center.y - radius, center.y + radius);
        this.radius=radius;
	}

	@Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        int x[]= {(int)(getAnchorPoint().getX()-radius), (int)(getAnchorPoint().getX()-radius/2), (int)(getAnchorPoint().getX()+radius/2), (int)(getAnchorPoint().getX()+radius), (int)(getAnchorPoint().getX()+radius/2), (int)(getAnchorPoint().getX()-radius/2)};
        int y[]= {(int)(getAnchorPoint().getY()), (int)(getAnchorPoint().getY()-radius*(Math.sqrt(3))/2), (int)(getAnchorPoint().getY()-radius*(Math.sqrt(3))/2), (int)(getAnchorPoint().getY()), (int)(getAnchorPoint().getY()+radius*(Math.sqrt(3))/2), (int)(getAnchorPoint().getY()+radius*(Math.sqrt(3))/2)};
        int npoints=x.length;
        g.fillPolygon(x, y, npoints);
    }

 
    
    public String toString() {
        return String.format("REGULARHEXAGON %d %d %d %s %s", 
                this.getAnchorPoint().x, 
                this.getAnchorPoint().y,
                this.radius,
                Util.colorToString(this.getColor()),
                this.isSelected());
    }

	@Override
	public void scale(double factor) {
		this.radius = (int)(factor * this.radius);
	}

}
