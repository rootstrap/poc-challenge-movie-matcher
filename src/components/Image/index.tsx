import React from 'react';
import { ImageProps, Image as RNImage } from 'react-native';

export type { ImageProps };

const Image: React.FunctionComponent<ImageProps> = ({
  resizeMode = 'contain',
  source,
  ...props
}) => <RNImage source={source} resizeMode={resizeMode} {...props} />;

export default Image;
