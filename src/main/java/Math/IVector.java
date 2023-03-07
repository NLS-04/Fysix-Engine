package Math;

public interface IVector {

    IVector add(IVector v);

    IVector sub(IVector v);

    IVector mul(double a);

    IVector add(IVector v, IVector u);

    IVector sub(IVector v, IVector u);

    IVector mul(IVector v, double a);

    double mag();

    double sqrMag();

    double dot(IVector v, IVector u);

    IVector normalize();

    IVector normalized(IVector v);

    IVector project(IVector v, IVector onto);

    IVector exclude(IVector v, IVector from);

    double vectorAngle(IVector v, IVector u);
}
